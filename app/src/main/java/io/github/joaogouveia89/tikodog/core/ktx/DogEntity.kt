package io.github.joaogouveia89.tikodog.core.ktx

import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity
import io.github.joaogouveia89.tikodog.core.data.local.entity.DogEntity
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

fun DogEntity.asDogModel(breed: BreedEntity): Dog =
    Dog(
        id = id,
        breed = breed.asBreedModel(),
        imageUrl = imageUrl
    )

fun List<DogEntity>.asDogModels(breeds: List<BreedEntity>) =
    map { dogEntity ->
        dogEntity.asDogModel(breeds.first { it.id == dogEntity.breedId })
    }
