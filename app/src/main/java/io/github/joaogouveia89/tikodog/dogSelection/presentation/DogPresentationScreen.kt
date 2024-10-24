package io.github.joaogouveia89.tikodog.dogSelection.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                    Text(text = "Content")
                }
            )
        }
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