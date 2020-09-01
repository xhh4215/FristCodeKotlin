package com.example.thefristcode.jetpackproject.savedata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_save_data_to_file.*
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import java.lang.StringBuilder

class SaveDataToFileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data_to_file)
        var value = editText.text.toString()
        Log.d("lgm", value)
        saveData.setOnClickListener {
            save("this is luan xiao hei")
        }
        getData.setOnClickListener {
            val value = get()
            editText.setText(value)
        }

    }


    private fun save(value: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(value)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun get(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return content.toString()
    }
}