package io.github.joaogouveia89.tikodog.dogSelection.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import io.github.joaogouveia89.tikodog.core.data.remote.api.DogApiService
import io.github.joaogouveia89.tikodog.dogSelection.data.repository.DogSelectionRepositoryImpl
import io.github.joaogouveia89.tikodog.dogSelection.data.source.DogSelectionLocalSourceImpl
import io.github.joaogouveia89.tikodog.dogSelection.data.source.DogSelectionRemoteSourceImpl
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource

@Module
@InstallIn(SingletonComponent::class)
object DogPresentationModule {

    @RemoteDogSelectionSource
    @Provides
    fun provideRemoteDogSelectionSource(
        dogApiService: DogApiService
    ): DogSelectionSource = DogSelectionRemoteSourceImpl(dogApiService)

    @LocalDogSelectionSource
    @Provides
    fun provideLocalDogSelectionSource(
        breedDao: BreedDao,
        dogDao: DogDao
    ): DogSelectionSource = DogSelectionLocalSourceImpl(breedDao, dogDao)

    @Provides
    fun provideDogPresentationRepository(
        @RemoteDogSelectionSource remoteSource: DogSelectionSource,
        @LocalDogSelectionSource localSource: DogSelectionSource,
        preferences: SharedPreferences
    ): DogSelectionRepository =
        DogSelectionRepositoryImpl(remoteSource, localSource, preferences)

}