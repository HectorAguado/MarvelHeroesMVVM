package com.haguado.marvel_herores_mvvm.data.net

import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface MarvelHeroesService {

    @GET(".")
    fun getMarvelHeroes(): Flowable<MarvelHeroResponse>

}