package io.github.joaogouveia89.tikodog.favorites.presentation

import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTopBar
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient

@Composable
fun FavoritesScreen(
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onDogClicked: (dog: Dog) -> Unit
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
        FavoritesContent(
            paddingValues = paddingValues,
            onDogClicked = onDogClicked
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun FavoritesScreenPreview() {
    TikoDogTheme {
        FavoritesScreen(
            onBackClick = {},
            onLogoutClick = {},
            onDogClicked = {}
        )
    }
}