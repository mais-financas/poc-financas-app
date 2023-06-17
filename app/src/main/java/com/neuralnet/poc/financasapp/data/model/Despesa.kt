package com.neuralnet.poc.financasapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Despesa(val nome: String, val valor: Double, val categoria: String)
