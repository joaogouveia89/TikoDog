package io.github.joaogouveia89.tikodog.dogSelection.presentation.state

import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

data class DogSelectionUiState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val isShuffleEnabled: Boolean = false,
    val breedListStr: List<String> = emptyList(),
    val selectText: String? = null,
    val currentDog: Dog? = null
)