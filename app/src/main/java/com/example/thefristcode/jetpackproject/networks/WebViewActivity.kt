package com.example.thefristcode.jetpackproject.networks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.thefristcode.jetpackproject.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_web_view.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer
import kotlin.concurrent.thread

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        sendRequestBtn.setOnClickListener {
            sendRequestWithHttpUrlConnection()
        }
    }


    private fun sendRequestWithHttpUrlConnection() {
        thread {
//            var connection: HttpURLConnection? = null
//            try {
//                val response = StringBuilder()
//                val url = URL("https://www.baidu.com")
//                connection = url.openConnection() as HttpURLConnection
//                connection.connectTimeout = 8000
//                connection.readTimeout = 8000
//                val input = connection.inputStream
//                val reader = BufferedReader(InputStreamReader(input))
//                reader.use {
//                    reader.forEachLine {
//                        response.append(it)
//                    }
//                }
//                showResponse(response.toString())
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            } finally {
//                connection?.disconnect()
//            }


            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://www.baidu.com")
                .build()
            val response = client.newCall(request).execute()
            val responseData = response.body?.string()
            if (responseData != null) {
                showResponse(responseData)
            }

            val gson = Gson()
            //一个模拟的虚拟的json数据
            // 这是解析一个单独的json数据对象
            val jsonData = "";
            val person = gson.fromJson(jsonData, Person::class.java)
            //这是一个模拟的json数组数据
            //这是解析一个pesonal 数组对象
            val jsonArrayData = ""
            val typeOf = object : TypeToken<List<Person>>() {}.type
            val personaray = gson.fromJson<List<Person>>(jsonArrayData, typeOf)
        }
    }


    private fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }

    }


}

class Person(val name: String, val age: Int) {

}