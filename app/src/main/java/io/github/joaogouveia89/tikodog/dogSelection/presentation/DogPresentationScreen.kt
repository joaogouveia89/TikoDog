package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTopBar
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient

@Composable
fun DogPresentationScreen(
    isFavorite: Boolean,
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onDogBreedSelectClick: () -> Unit,
    onShuffleClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier.background(backgroundGradient),
        topBar = {
            TikoDogTopBar(
                onBackClick = onBackClick,
                onLogoutClick = onLogoutClick
            )
        },
        backgroundColor = Color.Transparent
    ) { paddingValues ->
        DogPresentationContent(
            paddingValues,
            isFavorite,
            onDogBreedSelectClick,
            onShuffleClick,
            onFavoriteClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DogPresentationScreenPreview() {
    TikoDogTheme {
        DogPresentationScreen(
            isFavorite = false,
            onBackClick = {},
            onLogoutClick = {},
            onShuffleClick = {},
            onDogBreedSelectClick = {},
            onFavoriteClick = {}
        )
    }
}