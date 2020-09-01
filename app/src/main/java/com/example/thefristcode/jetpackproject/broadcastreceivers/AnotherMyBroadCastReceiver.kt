package com.example.thefristcode.jetpackproject.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AnotherMyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, " Recever in the AnotherMyBroadCastReceiver ", Toast.LENGTH_SHORT)
            .show()
        abortBroadcast()
    }
}
