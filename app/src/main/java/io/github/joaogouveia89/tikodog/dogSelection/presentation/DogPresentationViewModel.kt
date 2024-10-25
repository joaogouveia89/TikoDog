package io.github.joaogouveia89.tikodog.dogSelection.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.BreedListStatus
import io.github.joaogouveia89.tikodog.dogSelection.domain.repository.DogPresentationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogPresentationViewModel @Inject constructor(
    private val dogPresentationRepository: DogPresentationRepository
): ViewModel() {
    private val breedFetchState = MutableStateFlow<BreedListStatus>(BreedListStatus.Idle)

    init {
        viewModelScope.launch {
            breedFetchState.emitAll(dogPresentationRepository.getBreeds())

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