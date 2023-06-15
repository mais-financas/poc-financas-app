package com.neuralnet.poc.financasapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.neuralnet.poc.financasapp.ui.screens.chatbot.ChatBotScreen
import com.neuralnet.poc.financasapp.ui.screens.chatbot.ChatbotViewModel
import com.neuralnet.poc.financasapp.ui.screens.goals.FinancialGoalsScreen
import com.neuralnet.poc.financasapp.ui.screens.home.HomeScreen
import com.neuralnet.poc.financasapp.ui.screens.home.HomeViewModel

@Composable
fun FinancasNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(homeViewModel)
        }

        composable(Screen.ChatBot.route) {
            val chatBotViewModel: ChatbotViewModel = hiltViewModel()
            ChatBotScreen(chatBotViewModel)
        }

        composable(Screen.FinancialGoals.route) {
            FinancialGoalsScreen()
        }
    }
}