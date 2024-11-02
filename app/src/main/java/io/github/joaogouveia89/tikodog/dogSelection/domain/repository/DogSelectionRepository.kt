package io.github.joaogouveia89.tikodog.dogSelection.domain.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import kotlinx.coroutines.flow.Flow

sealed class BreedListStatus {
    data object Idle : BreedListStatus()
    data object Loading : BreedListStatus()
    data class Success(val breeds: List<Breed>) : BreedListStatus()
}

sealed class DogImageStatus {
    data object Idle : DogImageStatus()
    data object Loading : DogImageStatus()
    data class Success(val dogImageUrl: String) : DogImageStatus()
}

interface DogSelectionRepository {
    fun getBreeds(updateLocalDb: Boolean = false): Flow<BreedListStatus>
    suspend fun getDogImage(breed: Breed): Flow<DogImageStatus>
}