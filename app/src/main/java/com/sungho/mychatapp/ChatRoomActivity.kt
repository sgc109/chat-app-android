package com.sungho.mychatapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import kotlinx.android.synthetic.main.activity_chat_room.chat_room_activity_message_edit_text as editTxtMsg
import kotlinx.android.synthetic.main.activity_chat_room.chat_room_activity_recycler_view as recyclerViewChats
import kotlinx.android.synthetic.main.activity_chat_room.chat_room_activity_send_button as btnSend
import kotlinx.android.synthetic.main.activity_chat_room.chat_room_activity_toolbar as toolbar

class ChatRoomActivity : AppCompatActivity() {
    private val viewModel: ChatRoomViewModel by inject{ parametersOf(this)}
    var isSendBtnEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)

        setSupportActionBar(toolbar)

        btnSend.setOnClickListener {
            Log.d("sgc109", "button was clicked!")

            if(isSendBtnEnabled) {
                Log.d("sgc109", "send message!")

                viewModel.sendMessage(editTxtMsg.text.toString())
                editTxtMsg.text.clear()
            }
        }

        editTxtMsg.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                isSendBtnEnabled = (s != null && s.isNotEmpty())
            }
        })

        viewModel.newMessages.observe(this, Observer {

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.chat_room_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.menu_item_refresh -> {
            Log.d("sgc109", "reconnect!")
            viewModel.refresh()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    class ChatAdapter: RecyclerView.Adapter<ChatViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getItemCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    class ChatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}
