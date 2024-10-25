package io.github.joaogouveia89.tikodog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import io.github.joaogouveia89.tikodog.core.presentation.MainScreen
import io.github.joaogouveia89.tikodog.ui.theme.TikoDogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TikoDogTheme {
                MainScreen(
                    navController = rememberNavController(),
                )
            }
        }
    }
}