package io.github.joaogouveia89.tikodog.dogSelection.data.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DogSelectionRepositoryImpl @Inject constructor(
    private val dogSelectionSource: DogSelectionSource
) : DogSelectionRepository {
    override fun getBreeds(): Flow<BreedListStatus> = flow {
        emit(BreedListStatus.Loading)
        val breeds = dogSelectionSource
            .getBreeds()
            .sorted()
            .map {
                val breedAndSubBreed = it.split(" ")
                Breed(
                    humanized = it.replaceFirstChar { char -> char.uppercase() },
                    name = if (breedAndSubBreed.size == 1) breedAndSubBreed.first() else breedAndSubBreed.last(),
                    subBreed = if (breedAndSubBreed.size == 1) null else breedAndSubBreed.first()
                )
            }
        emit(BreedListStatus.Success(breeds))
    }.flowOn(Dispatchers.IO)
}