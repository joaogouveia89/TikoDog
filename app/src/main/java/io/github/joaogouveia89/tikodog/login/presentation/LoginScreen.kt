package io.github.joaogouveia89.tikodog.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import io.github.joaogouveia89.tikodog.ui.theme.TikoBlue
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.TikoPink

private val loginBackground = Brush.linearGradient(
    colors = listOf(
        TikoPink,
        TikoBlue
    ),
    start = Offset(0f, Float.POSITIVE_INFINITY),
    end = Offset(Float.POSITIVE_INFINITY, 0f)
)

@Composable
fun LoginScreen() {
    Scaffold { paddingValues ->

        LoginScreenContent(
            paddingValues = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(loginBackground)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    TikoDogTheme {
        LoginScreen()
    }
}