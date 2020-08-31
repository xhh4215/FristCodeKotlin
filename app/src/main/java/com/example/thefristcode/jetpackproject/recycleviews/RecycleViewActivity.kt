package com.example.thefristcode.jetpackproject.recycleviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {
    private val frutiList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        initFruit()
        val layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager
        val adapter = FruitAdapter(frutiList)
        recycleView.adapter = adapter

    }


    private fun initFruit() {
        frutiList.add("Apple")
        frutiList.add("Banana")
        frutiList.add("Orangle")
        frutiList.add("Watermelon")
        frutiList.add("Pear")
        frutiList.add("Pear")
        frutiList.add("Pear")
        frutiList.add("Pear")
        frutiList.add("Pear")
        frutiList.add("Grape")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("PineApple")
        frutiList.add("Apple")
        frutiList.add("Cherry")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")
        frutiList.add("Mango")

    }
}