package io.github.joaogouveia89.tikodog.core.ktx

import io.github.joaogouveia89.tikodog.core.data.local.entity.relation.DogWithBreed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog

fun DogWithBreed.asDogModel(): Dog =
    Dog(
        id = dog.id,
        breed = breed.asBreedModel(),
        imageUrl = dog.imageUrl
    )

fun List<DogWithBreed>.asDogModels() =
    map { dogEntity ->
        dogEntity.asDogModel()
    }
