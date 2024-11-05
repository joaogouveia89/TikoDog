package io.github.joaogouveia89.tikodog.favorites.presentation.state

import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

data class FavoritesUiState(
    val isLoading: Boolean = false,
    val dogs: List<Dog> = listOf()
)
