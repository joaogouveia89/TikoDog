package io.github.joaogouveia89.tikodog.dogSelection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.tikodog.core.data.remote.DogApiService
import io.github.joaogouveia89.tikodog.dogSelection.data.repository.DogPresentationRepositoryImpl
import io.github.joaogouveia89.tikodog.dogSelection.data.source.DogPresentationSourceImpl
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogPresentationRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogPresentationSource

@Module
@InstallIn(SingletonComponent::class)
object DogPresentationModule {

    @Provides
    fun provideDogPresentationSource(
        dogApiService: DogApiService
    ): DogPresentationSource =
        DogPresentationSourceImpl(dogApiService)

    @Provides
    fun provideDogPresentationRepository(
        dogPresentationSource: DogPresentationSource
    ): DogPresentationRepository =
        DogPresentationRepositoryImpl(dogPresentationSource)

}