package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogImageStatus
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
    data object OnShuffleClick : Event()
}

@HiltViewModel
class DogSelectionViewModel @Inject constructor(
    private val dogSelectionRepository: DogSelectionRepository
) : ViewModel() {
    private val breedFetchState = MutableStateFlow<BreedListStatus>(BreedListStatus.Idle)
    private val dogImageFetchState = MutableStateFlow<DogImageStatus>(DogImageStatus.Idle)

    private var breedList: List<Breed> = emptyList()

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
                    val breed = breedList.getOrNull(event.index)
                        ?: breedList.first()
                    val dog = currentState.currentDog?.copy(breed = breed) ?: Dog(breed = breed)
                    currentState.copy(
                        currentDog = dog,
                        selectText = breed.humanized,
                        isShuffleEnabled = true
                    )
                }
            }

            Event.OnShuffleClick -> {
                viewModelScope.launch {
                    _uiState.value.currentDog?.let {
                        dogImageFetchState.emitAll(dogSelectionRepository.getDogImage(it.breed))
                    }
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
                            breedList = status.breeds
                            DogSelectionUiState(
                                isLoading = false,
                                isShuffleEnabled = true,
                                breedListStr = breedList.map { it.humanized },
                                selectText = breedList.firstOrNull()?.humanized
                            )
                        }
                    }

                    is BreedListStatus.Loading -> {
                        _uiState.update {
                            DogSelectionUiState(
                                isLoading = true,
                                isShuffleEnabled = false
                            )
                        }
                    }

                    is BreedListStatus.Idle -> _uiState.update {
                        DogSelectionUiState()
                    }
                }

                dogImageFetchState.collectLatest {
                    when (it) {
                        is DogImageStatus.Success -> {
                            _uiState.update { currentState ->
                                val currentDog = currentState.currentDog
                                currentState.copy(
                                    currentDog = currentDog?.copy(imageUrl = it.dogImageUrl),
                                )
                            }
                        }

                        DogImageStatus.Idle -> {}
                        DogImageStatus.Loading -> {}
                    }
                }
            }
        }
    }
}