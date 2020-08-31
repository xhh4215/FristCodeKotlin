package com.example.thefristcode.jetpackproject.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.thefristcode.jetpackproject.R
import com.example.thefristcode.jetpackproject.fragments.LeftFragment
import kotlinx.android.synthetic.main.activity_simple_fragment.*
import kotlinx.android.synthetic.main.fragment_simple.*

class SimpleFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_fragment)
        button.setOnClickListener {
            val fragmet = LeftFragment as LeftFragment
            Toast.makeText(this, fragmet::class.java.name, Toast.LENGTH_SHORT).show()
            replceFragement(AnotherFragment())
        }
        replceFragement(RightFragment())

    }

    private fun replceFragement(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.anotherFragment, fragment)
        //添加到返回栈中
        transaction.addToBackStack(null)
        transaction.commit()
    }
}