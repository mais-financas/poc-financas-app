package com.neuralnet.poc.financasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neuralnet.poc.financasapp.ui.screens.chatbot.ChatBotScreen
import com.neuralnet.poc.financasapp.ui.screens.goals.FinancialGoalsScreen
import com.neuralnet.poc.financasapp.ui.screens.home.HomeScreen

@Composable
fun FinancasNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }

        composable(Screen.ChatBot.route) {
            ChatBotScreen()
        }

        composable(Screen.FinancialGoals.route) {
            FinancialGoalsScreen()
        }
    }
}