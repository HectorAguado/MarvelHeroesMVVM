package com.haguado.marvel_herores_mvvm.util.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.haguado.marvel_herores_mvvm.presentation.heroeslist.HeroesListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass


// Inyectamos por constructor un viewModels,  que es un mapeo de una clase ViewModel y un valor
// de una clase tipo ViewModel, devuelvo un valor de tipo ViewModel

@Singleton
class ViewModelFactory @Inject constructor(
        private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds  // similar a un Provide, solo que lo hace por debajo, se usa cun metodos abstractos
    @IntoMap
    @ViewModelKey(HeroesListViewModel::class)
    internal abstract fun postListViewModel(viewModel: HeroesListViewModel): ViewModel

    //Add more ViewModels here
//    @Binds
//    @IntoMap
//    @ViewModelKey(UserDetailViewModel::class)
//    internal abstract fun getUserDetailViewModel(viewModel: UserDetailViewModel): ViewModel
}