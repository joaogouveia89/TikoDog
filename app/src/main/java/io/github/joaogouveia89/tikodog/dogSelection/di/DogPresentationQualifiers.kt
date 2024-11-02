package io.github.joaogouveia89.tikodog.dogSelection.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDogSelectionSource

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDogSelectionSource