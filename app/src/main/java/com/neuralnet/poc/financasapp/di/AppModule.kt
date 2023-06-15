package com.neuralnet.poc.financasapp.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.neuralnet.poc.financasapp.data.network.BASE_URL
import com.neuralnet.poc.financasapp.data.network.BOTPRESS_BASE_URL
import com.neuralnet.poc.financasapp.data.network.BotpressApi
import com.neuralnet.poc.financasapp.data.network.PocFinancasApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFinancasApi(): PocFinancasApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(PocFinancasApi::class.java)

    @Singleton
    @Provides
    fun provideBotpressApi(): BotpressApi {
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .baseUrl(BOTPRESS_BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(BotpressApi::class.java)
    }
}