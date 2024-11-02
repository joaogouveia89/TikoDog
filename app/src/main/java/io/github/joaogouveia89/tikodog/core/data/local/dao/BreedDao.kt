package io.github.joaogouveia89.tikodog.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.github.joaogouveia89.tikodog.core.data.local.entity.BreedEntity

@Dao
interface BreedDao {
    @Insert
    suspend fun insertAll(breeds: List<BreedEntity>): List<Long>

    @Query("SELECT * FROM Breed ORDER BY humanized")
    suspend fun getAll(): List<BreedEntity>

    @Query("DELETE FROM Breed")
    suspend fun deleteAll()
}