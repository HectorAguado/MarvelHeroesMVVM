package com.haguado.marvel_herores_mvvm.di.components

import com.haguado.marvel_herores_mvvm.di.modules.ApplicationModule
import com.haguado.marvel_herores_mvvm.di.modules.DataModule
import com.haguado.marvel_herores_mvvm.di.modules.NetModule
import com.haguado.marvel_herores_mvvm.presentation.heroeslist.HeroesListActivity
import com.haguado.marvel_herores_mvvm.util.mvvm.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules =
[
    ApplicationModule::class,
    NetModule::class,
    DataModule::class,
    ViewModelModule::class
])


interface ApplicationComponent {

    fun inject(heroesListActivity: HeroesListActivity)

}