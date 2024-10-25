package io.github.joaogouveia89.tikodog.dogSelection.data.repository

import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogPresentationRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogPresentationSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DogPresentationRepositoryImpl @Inject constructor(
    private val dogPresentationSource: DogPresentationSource
): DogPresentationRepository {
    override fun getBreeds(): Flow<BreedListStatus> = flow {
        emit(BreedListStatus.Loading)
        val breeds = dogPresentationSource
            .getBreeds()
            .sorted()
        // TODO instead of a list of strings, send the dog breed objects
        emit(BreedListStatus.Success(breeds))
    }.flowOn(Dispatchers.IO)
}