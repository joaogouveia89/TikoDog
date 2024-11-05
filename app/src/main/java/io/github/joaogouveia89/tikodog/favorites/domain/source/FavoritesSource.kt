package io.github.joaogouveia89.tikodog.favorites.domain.source

import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

interface FavoritesSource {
    suspend fun getFavorites(): List<Dog>
}