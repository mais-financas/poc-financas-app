package com.neuralnet.poc.financasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neuralnet.poc.financasapp.ui.theme.PoCFinançasTheme

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
    PoCFinançasTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Android")
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