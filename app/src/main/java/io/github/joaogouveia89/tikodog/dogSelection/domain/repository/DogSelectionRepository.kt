package io.github.joaogouveia89.tikodog.dogSelection.domain.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
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

sealed class FavoriteStatus {
    data object Idle : FavoriteStatus()
    data object Loading : FavoriteStatus()
    data class Success(val dog: Dog) : FavoriteStatus()
}

interface DogSelectionRepository {
    suspend fun getBreeds(): Flow<BreedListStatus>
    suspend fun getDogImage(breed: Breed): Flow<DogImageStatus>
    suspend fun addRemoveFromFavorites(dog: Dog): Flow<FavoriteStatus>
}