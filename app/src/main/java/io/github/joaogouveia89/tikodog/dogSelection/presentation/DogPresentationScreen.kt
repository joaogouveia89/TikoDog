package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import io.github.joaogouveia89.tikodog.R
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTopBar
import io.github.joaogouveia89.tikodog.core.presentation.components.PanelScreenHeader
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogButton
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogPanelScreen
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray2
import io.github.joaogouveia89.tikodog.ui.theme.TikoPurple
import io.github.joaogouveia89.tikodog.ui.theme.TikoYellow
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
        containerColor = Color.Transparent
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