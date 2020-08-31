package com.example.thefristcode.jetpackproject.lifes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thefristcode.jetpackproject.R

class StartTestActivity : AppCompatActivity() {
    companion object {
        fun startTestActivity(data: String, context: Context) {
            Intent(context, StartTestActivity::class.java).apply {
                this.putExtra("data", data)
                context.startActivity(this)
            }


        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_test)
    }
}