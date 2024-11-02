package io.github.joaogouveia89.tikodog.core.ktx

import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed

fun Breed.asBreedEntity(): BreedEntity =
    BreedEntity(
        name = name,
        subBreed = subBreed,
        humanized = humanized
    )

fun List<Breed>.asBreedEntities(): List<BreedEntity> =
    map { it.asBreedEntity() }