package io.github.joaogouveia89.tikodog.dogSelection.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.joaogouveia89.tikodog.R
import io.github.joaogouveia89.tikodog.core.presentation.TikoDogTopBar
import io.github.joaogouveia89.tikodog.core.presentation.components.PanelScreenHeader
import io.github.joaogouveia89.tikodog.core.presentation.components.TikoDogPanelScreen
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray
import io.github.joaogouveia89.tikodog.ui.theme.TikoGray2
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DogPresentationScreen(
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit
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
                            onSelectClick = {}
                        )
                    }
                }
            )
        }
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


@Preview(showBackground = true)
@Composable
private fun DogPresentationScreenPreview() {
    TikoDogTheme {
        DogPresentationScreen(
            onBackClick = {},
            onLogoutClick = {}
        )
    }
}