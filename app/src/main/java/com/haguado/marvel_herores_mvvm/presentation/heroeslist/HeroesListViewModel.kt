package com.haguado.marvel_herores_mvvm.presentation.heroeslist

import android.arch.lifecycle.MutableLiveData
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.data.repository.MarvelHeroesRepository
import com.haguado.marvel_herores_mvvm.util.mvvm.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HeroesListViewModel @Inject constructor(
        val marvelHeroesRepository: MarvelHeroesRepository
): BaseViewModel() {

    val heroesListState: MutableLiveData<List<MarvelHeroEntity>> = MutableLiveData()

    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

    fun loadMarvelHeroesList(){
        marvelHeroesRepository.getMarvelHeroesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isLoadingState.postValue(true) }
                .doOnTerminate { isLoadingState.postValue(false) }
                .subscribeBy (
                        onNext = {
                            heroesListState.value = it
                        },
                        onError = {

                        },
                        onComplete = {
                            //TODO settingsManager.firstLoad
                        }
                ).addTo(compositeDisposable)
    }
}