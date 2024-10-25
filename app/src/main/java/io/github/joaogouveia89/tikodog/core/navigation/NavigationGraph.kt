package io.github.joaogouveia89.tikodog.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.github.joaogouveia89.tikodog.dogSelection.presentation.DogPresentationScreen
import io.github.joaogouveia89.tikodog.favorites.presentation.FavoritesScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.DogSelection.route
    ) {
        composable(BottomNavItem.DogSelection.route) {
            DogPresentationScreen(
                isFavorite = false,
                onBackClick = {},
                onLogoutClick = {},
                onShuffleClick = {},
                onDogBreedSelectClick = {},
                onFavoriteClick = {}
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