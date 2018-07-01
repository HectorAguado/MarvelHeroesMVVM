package com.haguado.marvel_herores_mvvm.data.repository.datasource

import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import io.reactivex.Flowable

interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Flowable<List<MarvelHeroEntity>>

}