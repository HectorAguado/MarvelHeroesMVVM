package com.haguado.marvel_herores_mvvm.presentation.heroeslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.haguado.marvel_herores_mvvm.R
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.presentation.MainApp
import kotlinx.android.synthetic.main.activity_heroes_list.*
import javax.inject.Inject

class HeroesListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var heroesListViewModel: HeroesListViewModel

    private val adapter = HeroesListAdapter{ hero, image ->
        onHeroClicked(hero)  //TODO
    }

    fun inject(){
        (application as MainApp).component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes_list)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        heroesListRecycler.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        heroesListRecycler.itemAnimator = DefaultItemAnimator()
        heroesListRecycler.adapter = adapter
    }
    private fun setUpViewModel(){
        heroesListViewModel = ViewModelProviders.of(this, viewModelFactory).get(HeroesListViewModel::class.java)
        bindevents()
        heroesListViewModel.loadMarvelHeroesList()
    }

    // para subscribirnos u Observar los eventos
    private fun bindevents(){
        heroesListViewModel.isLoadingState.observe(this, Observer { isLoading ->
            isLoading?.let {
                showLoading(it)
            }
        })
        heroesListViewModel.heroesListState.observe(this, Observer { userList ->
            userList?.let {
                onUserListLoaded(it)
            }
        })
    }

    // tengo un user nuevo, muestramelo en la lista
    private fun onUserListLoaded(heroList: List<MarvelHeroEntity>){
        //adapter.submitList(heroList)
        adapter.swapData(heroList)
    }

    private fun showLoading(isLoading: Boolean){
        heroesListLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun onHeroClicked(marvelHeroEntity: MarvelHeroEntity){

    }
}
