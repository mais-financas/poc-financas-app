package com.neuralnet.poc.financasapp.ui.screens.chatbot

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
import androidx.compose.ui.unit.dp
import com.neuralnet.poc.financasapp.data.model.Message

@Composable
fun ChatBotScreen(chatbotViewModel: ChatbotViewModel) {
    val messages by chatbotViewModel.messages.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
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

