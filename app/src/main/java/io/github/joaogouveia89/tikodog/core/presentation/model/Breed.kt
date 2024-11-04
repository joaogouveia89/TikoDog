package io.github.joaogouveia89.tikodog.core.presentation.model

data class Breed(
    val id: Long = 0,
    val humanized: String,
    val name: String,
    val subBreed: String?
)
