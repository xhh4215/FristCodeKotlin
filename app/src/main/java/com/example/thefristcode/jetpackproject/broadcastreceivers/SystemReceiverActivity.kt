package com.example.thefristcode.jetpackproject.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_system_receiver.*

class SystemReceiverActivity : AppCompatActivity() {
    lateinit var timeChangeRecevier: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_receiver)
        MyBradCast.setOnClickListener {
            val intent = Intent("com.example.broadcastrecever.MY_BROADCAST")
            intent.setPackage(packageName)
            sendOrderedBroadcast(intent,null)
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeRecevier = TimeChangeReceiver()
        registerReceiver(timeChangeRecevier, intentFilter)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeRecevier)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(
                context,
                "Time has changed ",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}