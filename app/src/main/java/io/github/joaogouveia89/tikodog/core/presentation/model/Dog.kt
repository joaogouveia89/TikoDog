package io.github.joaogouveia89.tikodog.core.presentation.model

data class Dog(
    val humanizedBreed: String,
    val breed: String,
    val subBreed: String? = null,
    val imageUrl: String
)
