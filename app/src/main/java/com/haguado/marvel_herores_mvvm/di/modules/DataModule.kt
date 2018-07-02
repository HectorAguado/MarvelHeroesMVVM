package com.haguado.marvel_herores_mvvm.di.modules

import com.haguado.marvel_herores_mvvm.data.mapper.MarvelHeroMapper
import com.haguado.marvel_herores_mvvm.data.net.MarvelHeroesService
import com.haguado.marvel_herores_mvvm.data.repository.MarvelHeroesRepository
import com.haguado.marvel_herores_mvvm.data.repository.datasource.RemoteMarvelHeroesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMarvelHeroMapper(): MarvelHeroMapper = MarvelHeroMapper()

    @Provides
    @Singleton
    fun provideRemoteMarvelHeroesDataSoruce(
            marvelHeroesService: MarvelHeroesService,
            marvelHeroMapper: MarvelHeroMapper
        ): RemoteMarvelHeroesDataSource =
            RemoteMarvelHeroesDataSource(marvelHeroesService, marvelHeroMapper)

    @Provides
    @Singleton
    fun provideMarvelHeroesRepository(
            marvelRemoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource
    ): MarvelHeroesRepository =
            MarvelHeroesRepository(marvelRemoteMarvelHeroesDataSource)


}