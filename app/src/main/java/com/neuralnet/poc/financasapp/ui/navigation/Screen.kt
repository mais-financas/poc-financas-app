package com.neuralnet.poc.financasapp.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.neuralnet.poc.financasapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen("home", R.string.home, Icons.Filled.Home)
    object ChatBot : Screen("chatbot", R.string.chatbot, Icons.Filled.Person)
    object FinancialGoals : Screen("financial-goals", R.string.financial_goals, Icons.Filled.List)
}

