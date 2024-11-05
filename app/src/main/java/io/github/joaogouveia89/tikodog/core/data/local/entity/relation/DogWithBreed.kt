package io.github.joaogouveia89.tikodog.core.data.local.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity
import io.github.joaogouveia89.tikodog.core.data.local.entity.DogEntity

data class DogWithBreed(
    @Embedded
    val dog: DogEntity,
    @Relation(parentColumn = "breedId", entityColumn = "id")
    val breed: BreedEntity
)