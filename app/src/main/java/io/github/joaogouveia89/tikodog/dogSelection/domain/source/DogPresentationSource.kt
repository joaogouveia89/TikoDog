package io.github.joaogouveia89.tikodog.dogSelection.domain.source

interface DogPresentationSource {
    suspend fun getBreeds(): List<String>
}