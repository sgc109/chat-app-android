package com.sungho.mychatapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_message")
data class ChatMessage (
        @PrimaryKey(autoGenerate = true) val uid: Int = 0,
        @ColumnInfo(name = "sender") val sender: String = "empty user",
        @ColumnInfo(name = "text") val text: String = "empty text",
        @ColumnInfo(name = "timestamp") val timestamp: Long = 0L
)