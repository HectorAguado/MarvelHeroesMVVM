package com.haguado.marvel_herores_mvvm.di.modules

import android.app.Application
import android.content.Context
import com.haguado.marvel_herores_mvvm.util.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = application.applicationContext

    @Singleton
    @Provides
    fun provideNavigator(): Navigator = Navigator()
}