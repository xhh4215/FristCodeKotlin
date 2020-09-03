package com.example.thefristcode.jetpackproject.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_fore_ground.*

class ForeGroundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fore_ground)
        start.setOnClickListener {
            Intent(this, MyService2::class.java)
                .apply {
                    startService(this)
                }
        }

    }
}