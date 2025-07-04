package com.gmmrcinco.myapplication.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gmmrcinco.myapplication.data.database.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun getAllPosts(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(post: Post)

    @Query("UPDATE posts SET title = :title, description = :description WHERE id = :postId")
    suspend fun updateSelected(title: String, description: String, postId: String)

    @Query("DELETE FROM posts WHERE id= :postId")
    suspend fun deletePost(postId: String)
}