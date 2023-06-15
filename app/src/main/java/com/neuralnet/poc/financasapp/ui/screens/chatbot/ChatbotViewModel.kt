package com.neuralnet.poc.financasapp.ui.screens.chatbot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neuralnet.poc.financasapp.data.model.Message
import com.neuralnet.poc.financasapp.data.network.BotpressApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ChatbotViewModel @Inject constructor(
    private val botpressApi: BotpressApi,
) : ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(listOf())
    val messages: StateFlow<List<Message>> = _messages

    init {
        listarMensagens()
    }

    private fun listarMensagens() = viewModelScope.launch {
        _messages.update {
            botpressApi.getMessagesByConversationId(UUID.randomUUID().toString())
                .messages.asReversed()
        }
    }
}