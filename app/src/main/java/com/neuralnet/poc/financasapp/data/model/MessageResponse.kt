package com.neuralnet.poc.financasapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MessageResponse(
    val messages: List<Message>,
)