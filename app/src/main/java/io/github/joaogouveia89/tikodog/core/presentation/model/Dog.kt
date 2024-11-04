package io.github.joaogouveia89.tikodog.core.presentation.model

data class Dog(
    val id: Long = 0L,
    val breed: Breed,
    val imageUrl: String? = null
)
