package com.haguado.marvel_herores_mvvm.data.repository.datasource

import com.haguado.marvel_herores_mvvm.data.db.HeroDatabase
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class LocalMarvelHeroesDataSource(val heroDatabase: HeroDatabase ): MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Flowable<List<MarvelHeroEntity>> =
            heroDatabase
                    .getHeroDao()
                    .getAllHeroes()
                    .toFlowable()

    fun saveHeroes(heroes: List<MarvelHeroEntity>){
        Observable.fromCallable {
            heroDatabase.getHeroDao().removeAndInsertHeroes(heroes)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}