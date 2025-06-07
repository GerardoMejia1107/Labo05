package com.gmmrcinco.myapplication.data.database

import android.app.Application
import androidx.room.Room

class InitDatabase : Application() {
    companion object {
        lateinit var database: BlogDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            context = this,
            BlogDatabase::class.java,
            "blog_database"
        ).fallbackToDestructiveMigration(false).build()
    }
}