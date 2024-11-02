package io.github.joaogouveia89.tikodog.dogSelection.domain.source

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed

interface DogSelectionSource {
    suspend fun getBreeds(): List<Breed>
    suspend fun getDogImage(breed: Breed): String
}