package io.github.joaogouveia89.tikodog.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.joaogouveia89.tikodog.core.data.local.TikoDogDatabase
import io.github.joaogouveia89.tikodog.core.data.local.dao.BreedDao
import io.github.joaogouveia89.tikodog.core.data.local.dao.DogDao
import javax.inject.Singleton

private const val TIKO_DOG_DATABASE_NAME = "tiko_dog_db"

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TikoDogDatabase::class.java,
        TIKO_DOG_DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideBreedDao(
        database: TikoDogDatabase
    ): BreedDao = database.breedDao()

    @Provides
    @Singleton
    fun provideDogDao(
        database: TikoDogDatabase
    ): DogDao = database.dogDao()
}