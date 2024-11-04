package io.github.joaogouveia89.tikodog.core.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


private const val PREFERENCES_NAME = "tiko_dog_preferences"

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {
    @Provides
    @Singleton
    fun providesPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences
    = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
}