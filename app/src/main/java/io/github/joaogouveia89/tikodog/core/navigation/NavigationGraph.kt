package io.github.joaogouveia89.tikodog.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.joaogouveia89.tikodog.dogSelection.presentation.DogSelectionScreen
import io.github.joaogouveia89.tikodog.dogSelection.presentation.DogSelectionViewModel
import io.github.joaogouveia89.tikodog.dogSelection.presentation.Event
import io.github.joaogouveia89.tikodog.favorites.presentation.FavoritesScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.DogSelection.route
    ) {
        composable(BottomNavItem.DogSelection.route) {
            val viewModel: DogSelectionViewModel = hiltViewModel()

            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            DogSelectionScreen(
                uiState = uiState,
                onBackClick = {},
                onLogoutClick = {},
                onShuffleClick = {
                    viewModel.dispatch(Event.OnShuffleClick)
                },
                onDogBreedSelected = {
                    viewModel.dispatch(Event.OnDogBreedSelected(it))
                },
                onFavoriteClick = {
                    println("FAVORITE CLICKED $it")
                }
            )
        }

        composable(BottomNavItem.MyFavorites.route) {
            FavoritesScreen(
                onBackClick = { },
                onLogoutClick = {},
                onDogClicked = {}
            )
        }
    }
}