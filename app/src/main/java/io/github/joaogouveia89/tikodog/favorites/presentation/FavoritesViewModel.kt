package io.github.joaogouveia89.tikodog.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.tikodog.favorites.domain.repository.FavoriteListStatus
import io.github.joaogouveia89.tikodog.favorites.domain.repository.FavoritesRepository
import io.github.joaogouveia89.tikodog.favorites.presentation.state.FavoritesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
): ViewModel() {

    private val favoritesGetState = MutableStateFlow<FavoriteListStatus>(FavoriteListStatus.Idle)

    val uiState =
        favoritesRepository
            .getFavorites()
            .map {
                when(it){
                    FavoriteListStatus.Idle -> { FavoritesUiState()}
                    FavoriteListStatus.Loading -> FavoritesUiState(isLoading = true)
                    is FavoriteListStatus.Success -> FavoritesUiState(dogs = it.dogs)
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = FavoritesUiState()
            )
}