package io.github.joaogouveia89.tikodog.dogSelection.data.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogImageStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DogSelectionRepositoryImpl @Inject constructor(
    private val remoteSource: DogSelectionSource,
    private val localSource: DogSelectionSource
) : DogSelectionRepository {
    override fun getBreeds(updateLocalDb: Boolean): Flow<BreedListStatus> = flow {
        emit(BreedListStatus.Loading)
        val breeds = remoteSource
            .getBreeds()
            .sortedBy { it.humanized }
        emit(BreedListStatus.Success(breeds))
    }.flowOn(Dispatchers.IO)

    override suspend fun getDogImage(breed: Breed): Flow<DogImageStatus> = flow {
        emit(DogImageStatus.Loading)
        val dogImageUrl = remoteSource.getDogImage(breed)
        emit(DogImageStatus.Success(dogImageUrl))
    }
}