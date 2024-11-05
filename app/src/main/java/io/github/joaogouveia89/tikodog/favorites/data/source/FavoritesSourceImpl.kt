package io.github.joaogouveia89.tikodog.favorites.data.source

import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import io.github.joaogouveia89.tikodog.core.ktx.asDogModels
import io.github.joaogouveia89.tikodog.core.presentation.model.Dog
import io.github.joaogouveia89.tikodog.favorites.domain.source.FavoritesSource
import javax.inject.Inject

class FavoritesSourceImpl @Inject constructor(
    private val dao: DogDao
): FavoritesSource {
    override suspend fun getFavorites(): List<Dog> =
        dao
            .getAll()
            .asDogModels()
}