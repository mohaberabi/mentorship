package com.mohaberabi.ipcapp.messanger

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class MessengerActivity : ComponentActivity() {


    private var messenger: Messenger? = null
    private var replyMessenger: Messenger? = null
    private var bounded by mutableStateOf(false)
    private var status by mutableStateOf("")


    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            messenger = Messenger(service)
            replyMessenger = Messenger(
                Handler(Looper.getMainLooper()) { msg ->
                    if (msg.what == MessangerService.MSG_REPLY) {
                        status = msg.obj as String
                        Toast.makeText(this@MessengerActivity, status, Toast.LENGTH_LONG).show()
                    }
                    true
                },
            )
            bounded = true
        }

        override fun onServiceDisconnected(className: ComponentName) {
            messenger = null
            bounded = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, MessangerService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        bounded = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MessengerServiceScreen(
                statusText = status,
                isBound = bounded,
                sendCommand = { sendMessage(it) }
            )

        }
    }

    private fun sendMessage(command: Int) {
        if (bounded) {
            try {
                val msg = Message.obtain(null, command)
                msg.replyTo = replyMessenger
                messenger?.send(msg)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

}