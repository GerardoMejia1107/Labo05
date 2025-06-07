package com.gmmrcinco.myapplication.utils

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmmrcinco.myapplication.data.database.InitDatabase
import com.gmmrcinco.myapplication.data.database.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class BlogsitoViewModel : ViewModel() {
    private val db = InitDatabase.database
    private val _listPosts = MutableStateFlow<List<Post>>(emptyList())
    val listPosts = _listPosts.asStateFlow()
    val showModal = mutableStateOf(false)
    val newPostTitle = mutableStateOf("")
    val newPostDescription = mutableStateOf("")

    fun showModal() {
        showModal.value = !showModal.value
    }

    private fun cleanFields() {
        newPostDescription.value = ""
        newPostTitle.value = ""
    }

    private fun getPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = db.postDao().getAllPosts().firstOrNull()

            if (result?.isEmpty() == true) {
                return@launch
            }

            db.postDao().getAllPosts().collect { lisPosts ->
                _listPosts.value = lisPosts
            }
        }
    }

    fun addNewPost() {
        if (newPostDescription.value.isEmpty()) {
            return
        }

        if (newPostTitle.value.isEmpty()) {
            return
        }

        val newPost = Post(
            title = newPostTitle.value,
            description = newPostDescription.value,
            author = "EnSeMirro"
        )

        viewModelScope.launch(Dispatchers.IO) {
            db.postDao().insertPost(newPost)
            getPosts()
        }

        cleanFields()
    }

    fun updatePost(title: String, description: String, id: String) {
        viewModelScope.launch {
            db.postDao().updateSelected(title, description, id)
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            db.postDao().deletePost(postId)
        }
    }

}