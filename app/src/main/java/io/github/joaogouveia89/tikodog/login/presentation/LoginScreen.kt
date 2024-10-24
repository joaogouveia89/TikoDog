package io.github.joaogouveia89.tikodog.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme
import io.github.joaogouveia89.tikodog.ui.theme.backgroundGradient


@Composable
fun LoginScreen() {
    Scaffold { paddingValues ->

        LoginScreenContent(
            paddingValues = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundGradient)
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