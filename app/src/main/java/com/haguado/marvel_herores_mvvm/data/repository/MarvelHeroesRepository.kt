package com.haguado.marvel_herores_mvvm.data.repository

import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.data.repository.datasource.RemoteMarvelHeroesDataSource
import io.reactivex.Flowable

class MarvelHeroesRepository(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource) {

    fun getMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            remoteMarvelHeroesDataSource.getMarvelHeroesList()
}