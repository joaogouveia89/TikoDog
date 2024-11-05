package io.github.joaogouveia89.tikodog.favorites.domain.repository

import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import kotlinx.coroutines.flow.Flow

sealed class FavoriteListStatus{
    data object Idle : FavoriteListStatus()
    data object Loading : FavoriteListStatus()
    data class Success(val dogs: List<Dog>) : FavoriteListStatus()
}


interface FavoritesRepository {
    fun getFavorites(): Flow<FavoriteListStatus>
}