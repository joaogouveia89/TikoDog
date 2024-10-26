package io.github.joaogouveia89.tikodog.dogSelection.data.source

import io.github.joaogouveia89.tikodog.core.data.remote.DogApiService
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import javax.inject.Inject

class DogSelectionSourceImpl @Inject constructor(
    private val dogApiService: DogApiService
): DogSelectionSource {
    override suspend fun getBreeds(): List<String> {
        val response = dogApiService.getDogBreeds()

        return response
            .message
            .flatMap { (breed, subBreeds) ->
            if (subBreeds.isEmpty()) {
                listOf(breed)
            } else {
                subBreeds.map { subBreed -> "$subBreed $breed" }
            }
        }
    }
}