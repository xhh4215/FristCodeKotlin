package com.example.thefristcode.jetpackproject.lifes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.thefristcode.jetpackproject.MainModelFactory
import com.example.thefristcode.jetpackproject.MainViewModel
import com.example.thefristcode.jetpackproject.R
import com.example.thefristcode.jetpackproject.lifes.StartTestActivity.Companion.startTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag", "onCreate()")
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("saveData")
            Log.d("tag", tempData!!)
        }
        startDialog.setOnClickListener {
            Intent(this, DiaLogActivity::class.java).apply {
                startActivity(this)
            }
        }
        startNormal.setOnClickListener {
            Intent(this, NormalActivity::class.java).apply {
                startActivity(this)
            }
        }
        startActivity.setOnClickListener {
            startTestActivity("优雅的启动一个activity", MainActivity@ this)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempdata = "something you just typed"
        outState.putString("saveData", tempdata)
    }

    override fun onStart() {
        super.onStart()
        Log.d("tag", "onStart()")

    }

    override fun onResume() {
        super.onResume()
        Log.d("tag", "onResume()")

    }

    override fun onPause() {
        super.onPause()
        Log.d("tag", "onPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.d("tag", "onStop()")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("tag", "onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("tag", "onRestart()")

    }
}