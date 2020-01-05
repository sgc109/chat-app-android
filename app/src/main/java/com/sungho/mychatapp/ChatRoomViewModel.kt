package com.sungho.mychatapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.sungho.mychatapp.network.ChatMessage
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.ShutdownReason
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.lifecycle.LifecycleRegistry

class ChatRoomViewModel(
        private val chatMessageRepository: ChatRoomRepository,
        private val lifecycleRegistry: LifecycleRegistry)
    : ViewModel() {
    var userId: LiveData<String>? = null

    val isConnected: LiveData<Boolean> = LiveDataReactiveStreams.fromPublisher(
            chatMessageRepository.connect().map {
                it is WebSocket.Event.OnConnectionOpened<*>
            }
    )
    val newMessages: LiveData<List<ChatMessage>> = LiveDataReactiveStreams.fromPublisher(
            chatMessageRepository.getMessages().toList().toFlowable()
    )

    fun sendMessage(text: String) {
        chatMessageRepository.sendMessage(text)
    }

    fun refresh() {
        lifecycleRegistry.onNext(Lifecycle.State.Stopped.WithReason(ShutdownReason.GRACEFUL))
        lifecycleRegistry.onNext(Lifecycle.State.Started)
    }

}