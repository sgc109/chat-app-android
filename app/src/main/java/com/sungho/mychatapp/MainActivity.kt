package com.sungho.mychatapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import com.sungho.mychatapp.network.ChatMessage
import com.sungho.mychatapp.network.ChatService
import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.ShutdownReason
import com.tinder.scarlet.lifecycle.LifecycleRegistry
import org.koin.android.ext.android.get

class MainActivity : AppCompatActivity() {
    private val chatService: ChatService = get()
    private val lifecycleRegistry: LifecycleRegistry = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.send_button).setOnClickListener {
            Log.d("sgc109", "button was clicked!")

            chatService.sendChatMessage(ChatMessage(event = "message", text = "hi"))
        }

        findViewById<Button>(R.id.reconnect_button).setOnClickListener {
            Log.d("sgc109", "reconnect!")

            lifecycleRegistry.onNext(Lifecycle.State.Stopped.WithReason(ShutdownReason.GRACEFUL))
            lifecycleRegistry.onNext(Lifecycle.State.Started)
        }
    }
}
