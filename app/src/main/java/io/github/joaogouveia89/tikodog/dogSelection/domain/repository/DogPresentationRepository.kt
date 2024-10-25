package io.github.joaogouveia89.tikodog.dogSelection.domain.repository

import kotlinx.coroutines.flow.Flow

sealed class BreedListStatus{
    data object Loading: BreedListStatus()
    data class Success(val breeds: List<String>): BreedListStatus()
}

interface DogPresentationRepository {
    fun getBreeds(): Flow<BreedListStatus>
}