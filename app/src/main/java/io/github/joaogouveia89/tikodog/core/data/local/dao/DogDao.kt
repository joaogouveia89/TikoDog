package io.github.joaogouveia89.tikodog.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.github.joaogouveia89.tikodog.core.data.local.entity.DogEntity
import io.github.joaogouveia89.tikodog.core.data.local.entity.relation.DogWithBreed

@Dao
interface DogDao {
    @Insert(
        onConflict = OnConflictStrategy.IGNORE
    )
    suspend fun insert(dogEntity: DogEntity): Long

    @Delete
    suspend fun delete(dogEntity: DogEntity)

    @Query("SELECT * FROM Dog")
    suspend fun getAll(): List<DogWithBreed>

    @Query("SELECT COUNT(*) FROM Dog WHERE imageUrl = :imageUrl")
    suspend fun registersCount(imageUrl: String): Int
}