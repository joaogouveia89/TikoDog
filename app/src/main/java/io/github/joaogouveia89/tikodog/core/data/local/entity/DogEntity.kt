package io.github.joaogouveia89.tikodog.core.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Dog",
    indices = [Index(value = ["breedId", "imageUrl"], unique = true)],
    foreignKeys = [
        ForeignKey(
            entity = BreedEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("breedId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val breedId: Long,
    val imageUrl: String
)
