package io.github.joaogouveia89.tikodog.favorites.data.repository

import io.github.joaogouveia89.tikodog.favorites.domain.repository.FavoriteListStatus
import io.github.joaogouveia89.tikodog.favorites.domain.repository.FavoritesRepository
import io.github.joaogouveia89.tikodog.favorites.domain.source.FavoritesSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class FavoritesRepositoryImpl @Inject constructor(
    private val favoritesSource: FavoritesSource
)
    : FavoritesRepository {
    override fun getFavorites(): Flow<FavoriteListStatus> = flow {
        emit(FavoriteListStatus.Loading)

        val favorites = favoritesSource.getFavorites()

        emit(FavoriteListStatus.Success(favorites))
    }.flowOn(Dispatchers.IO)
}