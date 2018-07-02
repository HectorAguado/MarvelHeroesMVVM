package com.haguado.marvel_herores_mvvm.di.modules

import com.haguado.marvel_herores_mvvm.data.net.MarvelHeroesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/bvyob/")  // BuildConfig.API_URL
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun provideMarvelHeroService(retrofit: Retrofit): MarvelHeroesService =
            retrofit.create(MarvelHeroesService::class.java)
}