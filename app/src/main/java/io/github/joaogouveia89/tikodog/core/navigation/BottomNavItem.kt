package io.github.joaogouveia89.tikodog.core.navigation

import androidx.annotation.DrawableRes
import io.github.joaogouveia89.tikodog.R

sealed class BottomNavItem(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
) {
    data object DogSelection : BottomNavItem(
        title = "Selection",
        icon = R.drawable.ic_dog,
        route = Routes.DOG_SELECTION
    )

    data object MyFavorites : BottomNavItem(
        title = "My Favorites",
        icon = R.drawable.ic_favorites,
        route = Routes.MY_FAVORITES
    )
}