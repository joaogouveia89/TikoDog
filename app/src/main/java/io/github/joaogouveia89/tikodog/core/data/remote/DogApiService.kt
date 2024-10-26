package io.github.joaogouveia89.tikodog.core.data.remote

import io.github.joaogouveia89.tikodog.core.data.remote.response.DogBreedsResponse
import io.github.joaogouveia89.tikodog.core.data.remote.response.DogImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): DogBreedsResponse

    @GET("breed/{breed}/images/random")
    suspend fun getRandomDogByBreed(@Path("breed") breed: String): DogImageResponse

    @GET("breed/{breed}/{subBreed}/images/random")
    suspend fun getRandomDogImageBySubBreed(
        @Path("breed") breed: String,
        @Path("subBreed") subBreed: String
    ): DogImageResponse
}