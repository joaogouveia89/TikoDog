package io.github.joaogouveia89.tikodog.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity
import io.github.joaogouveia89.tikodog.core.data.local.entity.DogEntity

@Database(
    entities = [BreedEntity::class, DogEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TikoDogDatabase: RoomDatabase() {
    abstract fun breedDao(): BreedDao
    abstract fun dogDao(): DogDao
}