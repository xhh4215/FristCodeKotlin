package com.example.thefristcode.jetpackproject.uis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_progress.*

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)
        progressBtn.setOnClickListener {
            progressBar.progress = progressBar.progress + 10
        }
    }
}