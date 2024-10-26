package io.github.joaogouveia89.tikodog.dogSelection.domain.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import kotlinx.coroutines.flow.Flow

sealed class BreedListStatus {
    data object Idle : BreedListStatus()
    data object Loading : BreedListStatus()
    data class Success(val breeds: List<Breed>) : BreedListStatus()
}

interface DogSelectionRepository {
    fun getBreeds(): Flow<BreedListStatus>
}