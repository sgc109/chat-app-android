package com.sungho.mychatapp

import com.sungho.mychatapp.database.ChatMessageDao
import com.sungho.mychatapp.network.ChatMessage
import com.sungho.mychatapp.network.ChatService
import io.reactivex.Flowable

class ChatRoomRepository(
        private val chatService: ChatService,
        private val chatMessageDao: ChatMessageDao) {
    fun sendMessage(text: String) {
        chatService.sendChatMessage(ChatMessage(event = "message", text = text))
    }

    fun getMessages(): Flowable<ChatMessage> =
            chatService.observeMessage()

    fun connect() =
            chatService.observeWebSocketEvent()

}