package com.neuralnet.poc.financasapp.data.network

import com.neuralnet.poc.financasapp.BuildConfig
import com.neuralnet.poc.financasapp.data.model.MessageResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BOTPRESS_BASE_URL = "https://api.botpress.cloud/v1/chat/"

interface BotpressApi {

    @Headers(
        "Authorization: ${BuildConfig.BOTPRESS_ACCESS_TOKEN}",
        "x-bot-id: ${BuildConfig.BOT_ID}"
    )
    @GET("messages")
    suspend fun getMessagesByConversationId(@Query("conversationId") conversationId: String): MessageResponse

}