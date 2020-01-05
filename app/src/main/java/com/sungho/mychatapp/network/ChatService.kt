package com.sungho.mychatapp.network

import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable

interface ChatService {
    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

    @Receive
    fun observeMessage(): Flowable<ChatMessage>

    @Send
    fun sendChatMessage(message: ChatMessage)

    @Send
    fun sendTextTest(text: String)
}