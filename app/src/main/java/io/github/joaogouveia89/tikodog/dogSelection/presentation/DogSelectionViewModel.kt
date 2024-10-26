package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogSelectionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogSelectionViewModel @Inject constructor(
    private val dogSelectionRepository: DogSelectionRepository
): ViewModel() {
    private val breedFetchState = MutableStateFlow<BreedListStatus>(BreedListStatus.Idle)

    init {
        viewModelScope.launch {
            breedFetchState.emitAll(dogSelectionRepository.getBreeds())

            breedFetchState.collectLatest {
                when(it) {
                    is BreedListStatus.Success -> {
                        println(it.breeds)
                    }
                    is BreedListStatus.Loading -> {}
                    is BreedListStatus.Idle -> {}
                }
            }
        }
    }
}