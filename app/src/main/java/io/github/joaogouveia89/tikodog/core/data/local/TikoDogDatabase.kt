package io.github.joaogouveia89.tikodog.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity

@Database(
    entities = [BreedEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TikoDogDatabase: RoomDatabase() {
    abstract fun breedDao(): BreedDao
}