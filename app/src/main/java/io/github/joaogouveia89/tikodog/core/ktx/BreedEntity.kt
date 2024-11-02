package io.github.joaogouveia89.tikodog.core.ktx

import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed

fun BreedEntity.asBreedModel(): Breed =
    Breed(
        name = name,
        subBreed = subBreed,
        humanized = humanized
    )

fun List<BreedEntity>.asBreedModels(): List<Breed> =
    map { it.asBreedModel() }