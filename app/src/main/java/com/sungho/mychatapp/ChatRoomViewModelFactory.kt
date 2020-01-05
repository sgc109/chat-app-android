package com.sungho.mychatapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tinder.scarlet.lifecycle.LifecycleRegistry

class ChatRoomViewModelFactory(private val chatMessageRepository: ChatRoomRepository,
                               private val lifecycleRegistry: LifecycleRegistry) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChatRoomViewModel(chatMessageRepository, lifecycleRegistry) as T
    }

}