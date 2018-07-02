package com.haguado.marvel_herores_mvvm.presentation

import android.app.Application
import com.haguado.marvel_herores_mvvm.di.components.ApplicationComponent
import com.haguado.marvel_herores_mvvm.di.components.DaggerApplicationComponent
import com.haguado.marvel_herores_mvvm.di.modules.ApplicationModule


class MainApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        // Inyección de dependencia
        component =
                DaggerApplicationComponent.builder()
                        .applicationModule(ApplicationModule(this))
                        .build()
    }
}