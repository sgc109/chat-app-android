package com.sungho.mychatapp.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChatMessage(
        val event: String? = null,
        val text: String? = null,
        val id: String? = null
)