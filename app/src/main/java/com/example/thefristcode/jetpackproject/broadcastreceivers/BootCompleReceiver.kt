package com.example.thefristcode.jetpackproject.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, " Boot Comple", Toast.LENGTH_SHORT).show()
    }
}
