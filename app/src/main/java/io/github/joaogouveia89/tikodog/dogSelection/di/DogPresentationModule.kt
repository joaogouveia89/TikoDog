package io.github.joaogouveia89.tikodog.dogSelection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.tikodog.core.data.remote.DogApiService
import io.github.joaogouveia89.tikodog.dogSelection.data.repository.DogSelectionRepositoryImpl
import io.github.joaogouveia89.tikodog.dogSelection.data.source.DogSelectionSourceImpl
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource

@Module
@InstallIn(SingletonComponent::class)
object DogPresentationModule {

    @Provides
    fun provideDogSelectionSource(
        dogApiService: DogApiService
    ): DogSelectionSource =
        DogSelectionSourceImpl(dogApiService)

    @Provides
    fun provideDogPresentationRepository(
        dogSelectionSource: DogSelectionSource
    ): DogSelectionRepository =
        DogSelectionRepositoryImpl(dogSelectionSource)

}