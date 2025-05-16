package com.gmmrcinco.labo6.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.gmmrcinco.labo6.model.Book

@Composable
fun BodyContent(
    vPadding: PaddingValues,
    snack: SnackbarHostState,
) {
    var books by remember{ mutableStateOf<List<Book>?>(null) }
    val scope = rememberCoroutineScope()

}