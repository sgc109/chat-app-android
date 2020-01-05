package com.sungho.mychatapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.sungho.mychatapp.network.ChatMessage

@Dao
interface ChatMessageDao {

    @Query("SELECT * FROM chat_message")
    fun getMessages(): LiveData<List<ChatMessage>>
}