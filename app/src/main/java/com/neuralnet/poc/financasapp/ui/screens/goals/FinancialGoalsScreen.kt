package com.neuralnet.poc.financasapp.ui.screens.goals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.neuralnet.poc.financasapp.R

@Composable
fun FinancialGoalsScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.em_construcao), contentDescription = "", modifier = Modifier.size(150.dp))
    }
}
