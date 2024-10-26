package io.github.joaogouveia89.tikodog.dogSelection.presentation.state

import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

data class DogSelectionUiState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val breedList: List<Breed> = emptyList(),
    val breedListStr: List<String> = emptyList(),
    val selectText: String? = null,
    val currentDog: Dog? = null
)