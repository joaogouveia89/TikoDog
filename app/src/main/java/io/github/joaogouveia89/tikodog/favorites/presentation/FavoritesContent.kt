package io.github.joaogouveia89.tikodog.favorites.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import io.github.joaogouveia89.tikodog.R
import io.github.joaogouveia89.tikodog.core.presentation.components.PanelScreenHeader
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogPanelScreen
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.dogSelection.presentation.DogPresentationImage

@Composable
fun FavoritesContent(
    paddingValues: PaddingValues,
    onDogClicked: (dog: Dog) -> Unit
) {
    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        TikoDogPanelScreen(
            header = PanelScreenHeader(
                icon = Icons.Default.Star,
                title = stringResource(R.string.my_favourite_dogs)
            ),
            content = {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    PanelContent(
                        onDogClicked = onDogClicked
                    )
                }
            }
        )
    }
}



@Composable
private fun PanelContent(
    favoriteDogs: List<Dog> = emptyList(),
    onDogClicked: (dog: Dog) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        items(favoriteDogs.size) { index ->
            FavoriteDogItem(
                dog = favoriteDogs[index],
                onDogClicked = onDogClicked
            )
        }
    }
}

@Composable
private fun FavoriteDogItem(
    dog: Dog,
    onDogClicked: (dog: Dog) -> Unit
) {

    AsyncImage(
        modifier = Modifier
            .clip(
                RoundedCornerShape(16.dp)
            )
            .clickable { onDogClicked(dog) },
        model = ImageRequest.Builder(LocalContext.current)
            .data(dog.imageUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        error = painterResource(R.drawable.dog_scared),
        placeholder = painterResource(R.drawable.dog_thinking),
        contentScale = ContentScale.Fit,
    )
}