package io.github.joaogouveia89.tikodog.core.data.remote

import io.github.joaogouveia89.tikodog.core.data.remote.response.DogBreedsResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): DogBreedsResponse
}