package com.gmmrcinco.labo6.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmmrcinco.labo6.model.Book
import com.gmmrcinco.labo6.model.BookRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private val _books = MutableStateFlow<List<Book>?>(null)
    val books = _books.asStateFlow()

    fun loadBooks() {
        viewModelScope.launch {
            _books.value = BookRepository.getBooks()
        }
    }
}