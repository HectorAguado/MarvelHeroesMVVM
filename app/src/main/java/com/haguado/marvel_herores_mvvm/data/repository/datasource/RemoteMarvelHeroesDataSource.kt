package com.haguado.marvel_herores_mvvm.data.repository.datasource

import com.haguado.marvel_herores_mvvm.data.mapper.MarvelHeroMapper
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.data.net.MarvelHeroesService
import io.reactivex.Flowable

class RemoteMarvelHeroesDataSource(private val marvelHeroesService: MarvelHeroesService,
                                   private val marvelHeroMapper: MarvelHeroMapper
): MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            marvelHeroesService.getMarvelHeroes()
                    .map { it.superheroes }
                    .map { marvelHeroMapper.transformList(it)}
}