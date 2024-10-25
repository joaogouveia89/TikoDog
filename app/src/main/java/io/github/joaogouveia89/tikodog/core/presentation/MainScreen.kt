package io.github.joaogouveia89.tikodog.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import io.github.joaogouveia89.tikodog.core.navigation.BottomNavigationBar
import io.github.joaogouveia89.tikodog.core.navigation.NavigationGraph

@Composable
fun MainScreen(navController: NavHostController) {

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavigationGraph(navController = navController)
            }
        }
    )
}