package io.github.joaogouveia89.tikodog.dogSelection.domain.source

interface DogSelectionSource {
    suspend fun getBreeds(): List<String>
}