package com.haguado.marvel_herores_mvvm.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.haguado.marvel_herores_mvvm.data.db.HeroDatabase
import com.haguado.marvel_herores_mvvm.data.mapper.MarvelHeroMapper
import com.haguado.marvel_herores_mvvm.data.net.MarvelHeroesService
import com.haguado.marvel_herores_mvvm.data.repository.MarvelHeroesRepository
import com.haguado.marvel_herores_mvvm.data.repository.datasource.LocalMarvelHeroesDataSource
import com.haguado.marvel_herores_mvvm.data.repository.datasource.RemoteMarvelHeroesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMarvelHeroEntityMapper(): MarvelHeroMapper = MarvelHeroMapper()

    @Provides
    @Singleton
    fun provideDataBase(context: Context): HeroDatabase =
            Room.databaseBuilder(context, HeroDatabase::class.java, "heroes.db").build()

    @Provides
    @Singleton
    fun provideLocalMarvelHeroesDataSource(heroDatabase: HeroDatabase): LocalMarvelHeroesDataSource =
            LocalMarvelHeroesDataSource(heroDatabase)


    @Provides
    @Singleton
    fun provideRemoteMarvelHeroesDataSource(
            marvelHeroesService: MarvelHeroesService,
            marvelHeroMapper: MarvelHeroMapper
        ): RemoteMarvelHeroesDataSource =
            RemoteMarvelHeroesDataSource(marvelHeroesService, marvelHeroMapper)

    @Provides
    @Singleton
    fun provideMarvelHeroesRepository(
            localMarvelHeroesDataSource: LocalMarvelHeroesDataSource,
            remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource
    ): MarvelHeroesRepository =
            MarvelHeroesRepository(localMarvelHeroesDataSource,remoteMarvelHeroesDataSource)


}