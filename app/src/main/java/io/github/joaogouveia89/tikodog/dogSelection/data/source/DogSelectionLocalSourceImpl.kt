package io.github.joaogouveia89.tikodog.dogSelection.data.source

import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import io.github.joaogouveia89.tikodog.core.ktx.asBreedEntities
import io.github.joaogouveia89.tikodog.core.ktx.asBreedModels
import io.github.joaogouveia89.tikodog.core.ktx.asDogEntity
import io.github.joaogouveia89.tikodog.core.ktx.asDogModels
import io.github.joaogouveia89.tikodog.core.presentation.model.Breed
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.dogSelection.domain.source.DogSelectionSource
import javax.inject.Inject

class DogSelectionLocalSourceImpl @Inject constructor(
    private val breedDao: BreedDao,
    private val dogDao: DogDao
): DogSelectionSource{
    override suspend fun getBreeds(): List<Breed> =
        breedDao
            .getAll()
            .asBreedModels()

    override suspend fun getDogImage(breed: Breed): String {
        // NOT NECESSARY FOR LOCAL STORAGE SO FAR
        return ""
    }

    suspend fun addDogToFavorite(dog: Dog){
        dogDao.insert(dog.asDogEntity())
    }

    suspend fun removeDogFavorite(dog: Dog){
        dogDao.delete(dog.asDogEntity())
    }

    suspend fun updateBreeds(breeds: List<Breed>){
        breedDao.deleteAll()
        breedDao.insertAll(breeds.asBreedEntities())
    }

    suspend fun getDogs(): List<Dog>{
        val dogs = dogDao
            .getAll()
        val breeds = breedDao.getAll()

        return dogs.asDogModels(breeds)
    }
}