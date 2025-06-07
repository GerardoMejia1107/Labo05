package com.gmmrcinco.myapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey(autoGenerate = false) val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val author: String
)
