package io.github.joaogouveia89.tikodog.dogSelection.data.source

import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.ktx.asBreedEntities
import io.github.joaogouveia89.tikodog.core.ktx.asBreedModels
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import javax.inject.Inject

class DogSelectionLocalSourceImpl @Inject constructor(
    private val breedDao: BreedDao
): DogSelectionSource{
    override suspend fun getBreeds(): List<Breed> =
        breedDao
            .getAll()
            .asBreedModels()

    override suspend fun getDogImage(breed: Breed): String {
        return ""
    }

    suspend fun updateBreeds(breeds: List<Breed>){
        breedDao.deleteAll()
        breedDao.insertAll(breeds.asBreedEntities())
    }
}