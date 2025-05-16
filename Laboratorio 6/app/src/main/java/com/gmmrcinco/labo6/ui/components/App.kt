package com.gmmrcinco.labo6.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gmmrcinco.labo6.ui.viewmodel.BookViewModel
import kotlinx.coroutines.launch

@Composable
fun App() {
    val viewModel: BookViewModel = viewModel()
    val libros by viewModel.books.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Button(onClick = {
                viewModel.loadBooks()
                scope.launch {
                    snackbarHostState.showSnackbar("Cargando libros...")
                }
            }) {
                Text("Cargar libros")
            }

            Spacer(modifier = Modifier.height(16.dp))

            libros?.let {
                LazyColumn {
                    items(it) { book ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(book.name)
                                Text("Author: ${book.author}")
                            }
                        }
                    }
                }
            } ?: Text("Pulsa el botón para cargar libros.")
        }
    }
}