package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import io.github.joaogouveia89.tikodog.dogSelection.presentation.state.DogSelectionUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class Event {
    data class OnDogBreedSelected(val index: Int) : Event()
}

@HiltViewModel
class DogSelectionViewModel @Inject constructor(
    private val dogSelectionRepository: DogSelectionRepository
) : ViewModel() {
    private val breedFetchState = MutableStateFlow<BreedListStatus>(BreedListStatus.Idle)

    private val _uiState = MutableStateFlow(DogSelectionUiState())
    val uiState = _uiState.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(),
        initialValue = DogSelectionUiState()
    )

    fun dispatch(event: Event) {
        when (event) {
            is Event.OnDogBreedSelected -> {
                _uiState.update { currentState ->
                    val breed = currentState.breedList.getOrNull(event.index)
                        ?: currentState.breedList.first()
                    val dog = currentState.currentDog ?: Dog(breed)
                    currentState.copy(
                        currentDog = dog,
                        selectText = breed.humanized
                    )
                }
            }
        }
    }

    init {
        viewModelScope.launch {
            breedFetchState.emitAll(dogSelectionRepository.getBreeds())

            breedFetchState.collectLatest { status ->
                when (status) {
                    is BreedListStatus.Success -> {
                        _uiState.update {
                            DogSelectionUiState(
                                isLoading = false,
                                breedList = status.breeds,
                                breedListStr = status.breeds.map { it.humanized },
                                selectText = status.breeds.firstOrNull()?.humanized
                            )
                        }

                    }

                    is BreedListStatus.Loading -> {
                        _uiState.update {
                            DogSelectionUiState(
                                isLoading = true
                            )
                        }
                    }

                    is BreedListStatus.Idle -> _uiState.update {
                        DogSelectionUiState()
                    }
                }
            }
        }
    }
}