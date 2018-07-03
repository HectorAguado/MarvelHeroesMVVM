package com.haguado.marvel_herores_mvvm.util

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.view.View
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity
import com.haguado.marvel_herores_mvvm.presentation.heroesdetail.HeroDetailActivity

class Navigator {

    fun goToHeroDetail(activity: Activity, hero: MarvelHeroEntity, image: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, image,
                ViewCompat.getTransitionName(image))
        val intent = Intent(activity, HeroDetailActivity::class.java)
        intent.putExtra(HeroDetailActivity.PARAM_HEROE, hero)
        activity.startActivity(intent, options.toBundle())
    }
}