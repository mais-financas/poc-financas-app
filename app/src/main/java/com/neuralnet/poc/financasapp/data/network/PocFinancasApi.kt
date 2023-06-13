package com.neuralnet.poc.financasapp.data.network

import com.neuralnet.poc.financasapp.data.model.Gestor
import retrofit2.http.GET

const val BASE_URL = "http://192.168.0.21:8080/api/"

interface PocFinancasApi {

    @GET("gestores")
    suspend fun listarGestores(): List<Gestor>
}