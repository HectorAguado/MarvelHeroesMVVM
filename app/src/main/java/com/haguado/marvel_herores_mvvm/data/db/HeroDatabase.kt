package com.haguado.marvel_herores_mvvm.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.haguado.marvel_herores_mvvm.data.model.MarvelHeroEntity


@Database(entities = [MarvelHeroEntity::class], version = 1)
abstract class HeroDatabase: RoomDatabase(){

        abstract fun getHeroDao(): HeroDao

    }
