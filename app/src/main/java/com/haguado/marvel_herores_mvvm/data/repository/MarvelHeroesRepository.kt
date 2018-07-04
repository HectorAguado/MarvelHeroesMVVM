package com.haguado.marvel_herores_mvvm.data.repository

import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.data.repository.datasource.LocalMarvelHeroesDataSource
import com.haguado.marvel_herores_mvvm.data.repository.datasource.RemoteMarvelHeroesDataSource
import io.reactivex.Flowable

class MarvelHeroesRepository(private val localMarvelHeroesDataSource: LocalMarvelHeroesDataSource,
                             private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource) {

    fun getMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            getMarvelHeroesFromDb()
                    .concatWith(getMarvelHeroesFromApi())

    private fun getMarvelHeroesFromDb(): Flowable<List<MarvelHeroEntity>> =
            localMarvelHeroesDataSource.getMarvelHeroesList()

    private fun getMarvelHeroesFromApi(): Flowable<List<MarvelHeroEntity>> =
            remoteMarvelHeroesDataSource.getMarvelHeroesList()
                    .doOnNext { localMarvelHeroesDataSource.saveHeroes(it) }

}