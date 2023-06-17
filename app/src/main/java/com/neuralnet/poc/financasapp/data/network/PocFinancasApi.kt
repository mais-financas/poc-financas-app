package com.neuralnet.poc.financasapp.data.network

import com.neuralnet.poc.financasapp.data.model.Despesa
import com.neuralnet.poc.financasapp.data.model.Gestor
import retrofit2.http.GET

const val BASE_URL = "http://192.168.0.21:8080/api/"

interface PocFinancasApi {

    @GET("gestores/00a7b810-9dad-11d1-80b4-00c04fd430c8")
    suspend fun listarGestores(): List<Gestor>

    @GET("gestores/00a7b810-9dad-11d1-80b4-00c04fd430c8/despesas")
    suspend fun listarDespesas(): List<Despesa>
}