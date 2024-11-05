package io.github.joaogouveia89.tikodog.core.ktx

import io.github.joaogouveia89.tikodog.core.data.local.entity.DogEntity
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

fun Dog.asDogEntity(): DogEntity = DogEntity(
    id = id,
    breedId = breed.id,
    imageUrl = imageUrl ?: ""
)