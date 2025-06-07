package com.gmmrcinco.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gmmrcinco.myapplication.navigation.RootNavigation
import com.gmmrcinco.myapplication.ui.theme.MyApplicationTheme
import com.gmmrcinco.myapplication.utils.BlogsitoViewModel

class MainActivity : ComponentActivity() {
    private val viewModel = BlogsitoViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootNavigation(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

