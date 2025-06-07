package com.gmmrcinco.myapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gmmrcinco.myapplication.data.database.daos.PostDao

@Database(entities = [Post::class], version = 1)
abstract class BlogDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}