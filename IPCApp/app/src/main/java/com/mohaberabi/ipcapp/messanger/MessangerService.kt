package com.mohaberabi.ipcapp.messanger

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.util.Log

class MessangerService : Service() {

    companion object {
        const val MSG_START_TASK = 1
        const val MSG_STOP_TASK = 2
        const val MSG_CHECK_STATUS = 3
        const val MSG_REPLY = 4
    }

    private val handler = Handler(Looper.getMainLooper()) { message ->
        when (message.what) {
            MSG_START_TASK -> sendMessageBack(message, "Task started")
            MSG_STOP_TASK -> sendMessageBack(message, "Task stopped")
            MSG_CHECK_STATUS -> sendMessageBack(message, "Task is running")
            else -> false
        }
    }

    private val messenger = Messenger(handler)


    override fun onBind(intent: Intent?): IBinder? = messenger.binder

    private fun sendMessageBack(message: Message, replyText: String): Boolean {
        return try {
            val replyMessage = Message.obtain(null, MSG_REPLY)
            replyMessage.obj = replyText
            message.replyTo?.send(replyMessage)
            true
        } catch (e: Exception) {
            Log.e("MessengerService", "Error sending message back", e)
            false
        }
    }

}