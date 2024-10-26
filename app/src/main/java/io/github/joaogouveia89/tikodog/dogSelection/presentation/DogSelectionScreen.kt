package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTopBar
import io.github.joaogouveia89.tikodog.dogSelection.presentation.state.DogSelectionUiState
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient

@Composable
fun DogSelectionScreen(
    uiState: DogSelectionUiState,
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onDogBreedSelected: (Int) -> Unit,
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
        DogSelectionContent(
            modifier = Modifier
                .fillMaxHeight(),
            paddingValues =
            paddingValues, uiState = uiState,
            onDogBreedSelected = onDogBreedSelected,
            onShuffleClick = onShuffleClick,
            onFavoriteClick = onFavoriteClick
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DogSelectionScreenPreview() {
    TikoDogTheme {
        DogSelectionScreen(
            uiState = DogSelectionUiState(),
            onBackClick = {},
            onLogoutClick = {},
            onShuffleClick = {},
            onDogBreedSelected = {},
            onFavoriteClick = {}
        )
    }
}