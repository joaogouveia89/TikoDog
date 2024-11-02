package io.github.joaogouveia89.tikodog.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Breed")
data class BreedEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val subBreed: String?,
    val humanized: String,
)
