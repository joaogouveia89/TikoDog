package io.github.joaogouveia89.tikodog.favorites.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import io.github.joaogouveia89.tikodog.favorites.data.repository.FavoritesRepositoryImpl
import io.github.joaogouveia89.tikodog.favorites.data.source.FavoritesSourceImpl
import io.github.joaogouveia89.tikodog.favorites.domain.repository.FavoritesRepository
import io.github.joaogouveia89.tikodog.favorites.domain.source.FavoritesSource

@Module
@InstallIn(SingletonComponent::class)
object FavoritesModule {

    @Provides
    fun provideFavoritesSource(
        dogDao: DogDao
    ): FavoritesSource = FavoritesSourceImpl(dogDao)

    @Provides
    fun provideFavoritesRepository(
        favoritesSource: FavoritesSource
    ): FavoritesRepository = FavoritesRepositoryImpl(favoritesSource)
}