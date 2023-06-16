package com.neuralnet.poc.financasapp.ui.screens.chatbot

import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.neuralnet.poc.financasapp.data.model.Message
import com.neuralnet.poc.financasapp.databinding.FragmentChatBinding

@Composable
fun ChatBotScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        AndroidViewBinding(FragmentChatBinding::inflate) {
            this.webView.apply {
                webViewClient = WebViewClient()
            loadUrl("https://mediafiles.botpress.cloud/b6cf7b0a-6c47-49c4-893b-3c81b3b479dd/webchat/bot.html")
                settings.domStorageEnabled = true
                settings.javaScriptEnabled = true
                settings.setSupportZoom(true)
            }
        }
    }
}

@Composable
fun MessageCard(message: Message, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Text(text = message.payload.text, modifier = Modifier.padding(8.dp))
    }
}

