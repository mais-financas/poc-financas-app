package com.neuralnet.poc.financasapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Gestor(
    val id: String,
    val nome: String,
    val email: String,
)
