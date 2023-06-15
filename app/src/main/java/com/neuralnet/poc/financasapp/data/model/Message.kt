package com.neuralnet.poc.financasapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val conversationId: String,
    val id: String,
    val payload: Payload,
    val direction: String,
    val userId: String,
)