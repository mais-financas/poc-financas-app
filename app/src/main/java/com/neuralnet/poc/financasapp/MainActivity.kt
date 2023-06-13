package com.neuralnet.poc.financasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.neuralnet.poc.financasapp.ui.navigation.FinancasBottomBar
import com.neuralnet.poc.financasapp.ui.navigation.FinancasNavHost
import com.neuralnet.poc.financasapp.ui.theme.PoCFinançasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocFinancasApp()
        }
    }
}

@Composable
fun PocFinancasApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    PoCFinançasTheme {
        Scaffold(
            bottomBar = { FinancasBottomBar(navController = navController) },
            modifier = modifier.fillMaxSize(),
        ) { paddingValues ->
            FinancasNavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary),
        fontSize = MaterialTheme.typography.displayLarge.fontSize
    )
}


@Preview(showBackground = true)
@Composable
fun PocFinancasPreview() {
    PocFinancasApp()
}
