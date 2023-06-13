package com.neuralnet.poc.financasapp.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.neuralnet.poc.financasapp.data.model.Gestor

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val gestores by homeViewModel.gestores.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(gestores) { gestor ->
                GestorItem(gestor)
            }
        }
    }
}

@Composable
fun GestorItem(gestor: Gestor, modifier: Modifier = Modifier) {

    Card(modifier = modifier.padding(8.dp)) {
        Text(text = gestor.toString())
    }
}