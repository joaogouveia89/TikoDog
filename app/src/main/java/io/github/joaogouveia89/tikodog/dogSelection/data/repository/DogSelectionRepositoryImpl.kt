package io.github.joaogouveia89.tikodog.dogSelection.data.repository

import android.content.SharedPreferences
import android.util.Log
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.dogSelection.data.source.DogSelectionLocalSourceImpl
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogImageStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.FavoriteStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.until
import javax.inject.Inject

private const val BREED_LIST_LAST_UPDATED_MS = "breed_list_last_updated_ms"
private const val LAST_TIME_UPDATED_PREFERENCES_DEFAULT = -1L
private const val MONTHS_TO_REQUIRE_LOCAL_DB_UPDATE = 1

class DogSelectionRepositoryImpl @Inject constructor(
    private val remoteSource: DogSelectionSource,
    private val localSource: DogSelectionSource,
    private val preferences: SharedPreferences
) : DogSelectionRepository {
    override suspend fun getBreeds(): Flow<BreedListStatus> = flow {
        emit(BreedListStatus.Loading)
        if (shouldUpdateLocalDb()) {
            val breeds = remoteSource
                .getBreeds()
                .sortedBy { it.humanized }

            val localSourceImpl = localSource as DogSelectionLocalSourceImpl
            localSourceImpl.updateBreeds(breeds)
            emit(BreedListStatus.Success(breeds))
        } else {
            val breeds = localSource
                .getBreeds()
                .sortedBy { it.humanized }

            emit(BreedListStatus.Success(breeds))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getDogImage(breed: Breed): Flow<DogImageStatus> = flow {
        emit(DogImageStatus.Loading)
        val dogImageUrl = remoteSource.getDogImage(breed)
        emit(DogImageStatus.Success(dogImageUrl))
    }.flowOn(Dispatchers.IO)

    override suspend fun addRemoveFromFavorites(dog: Dog): Flow<FavoriteStatus> = flow {
        emit(FavoriteStatus.Loading)
        val localSourceImpl = localSource as DogSelectionLocalSourceImpl
        localSourceImpl.removeDogFavorite(dog)
        localSourceImpl.addDogToFavorite(dog)
        emit(FavoriteStatus.Success)
    }.flowOn(Dispatchers.IO)

    private fun shouldUpdateLocalDb(): Boolean {
        val lastTimeUpdated =
            preferences.getLong(BREED_LIST_LAST_UPDATED_MS, LAST_TIME_UPDATED_PREFERENCES_DEFAULT)
        val currentMoment = Clock.System.now()

        if (lastTimeUpdated == LAST_TIME_UPDATED_PREFERENCES_DEFAULT) {
            with(preferences.edit()) {
                putLong(BREED_LIST_LAST_UPDATED_MS, currentMoment.toEpochMilliseconds())
                apply()
            }
            return true
        }

        val updatedInstant = Instant.fromEpochMilliseconds(lastTimeUpdated)
        val period = updatedInstant.until(
            other = currentMoment,
            unit = DateTimeUnit.MONTH,
            timeZone = TimeZone.UTC
        )

        return period >= MONTHS_TO_REQUIRE_LOCAL_DB_UPDATE
    }
}