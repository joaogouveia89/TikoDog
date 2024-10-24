package io.github.joaogouveia89.tikodog.dogSelection.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogPanelScreen
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray2
import io.github.joaogouveia89.tikodog.ui.theme.TikoYellow
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DogPresentationScreen(
    isFavorite: Boolean,
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onDogBreedSelectClick: () -> Unit
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
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TikoDogPanelScreen(
                header = PanelScreenHeader(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_dog),
                    title = stringResource(R.string.dog_selection)
                ),
                content = {
                    PanelContent(
                        isFavorite = isFavorite,
                        onDogBreedSelectClick = onDogBreedSelectClick
                    )
                }
            )
        }
    }
}

@Composable
private fun PanelContent(
    isFavorite: Boolean,
    onDogBreedSelectClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.dog_breed),
            style = MaterialTheme.typography.bodySmall
        )
        TikoDogSelectDogBreed(
            modifier = Modifier.padding(top = 4.dp),
            text = stringResource(R.string.select),
            onSelectClick = onDogBreedSelectClick
        )

        DogImage(
            modifier = Modifier
                .padding(top = 40.dp),
            imageUrl = "",
            isFavorite = isFavorite
        )
    }
}

@Composable
private fun TikoDogSelectDogBreed(
    modifier: Modifier = Modifier,
    text: String,
    onSelectClick: () -> Unit
) {
    Row(
        modifier = modifier
            .border(
                border = BorderStroke(1.dp, TikoGray2),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .fillMaxWidth()
            .clickable { onSelectClick() }
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            tint = TikoGray,
            contentDescription = null
        )
    }
}

@Composable
fun DogImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    isFavorite: Boolean = false
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            error = painterResource(R.drawable.dog_scared),
            placeholder = painterResource(R.drawable.dog_thinking),
            contentScale = ContentScale.Fit,
        )

        val icon = if (isFavorite)
            ImageVector.vectorResource(id = R.drawable.star_fiiled)
        else
            Icons.Outlined.StarOutline

        val bgColor = if (isFavorite)
            TikoYellow
        else
            Color.White

        val iconColor = if (isFavorite)
            Color.Unspecified
        else
            TikoYellow

        IconButton(
            modifier = Modifier
                .offset(
                    x = 15.dp,
                    y = (-15).dp
                )
                .size(50.dp)
                .background(bgColor, shape = CircleShape) // Apply background with CircleShape
                .border(
                    1.dp,
                    TikoYellow,
                    shape = CircleShape
                )
                .align(Alignment.TopEnd),
            onClick = { /*TODO*/ },
            content = {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor
                )
            }
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
            onDogBreedSelectClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DogPresentationScreenFavoritePreview() {
    TikoDogTheme {
        DogPresentationScreen(
            onBackClick = {},
            onLogoutClick = {},
            onDogBreedSelectClick = {},
            isFavorite = true
        )
    }
}