package com.example.thefristcode.jetpackproject.savedata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_sharepreference.*

class SharepreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharepreference)
        btnActivity.setOnClickListener {

            val preference = getPreferences(Context.MODE_PRIVATE)
            val preferenceEdit = preference.edit()
            preferenceEdit.putBoolean("boolean", true)
            preferenceEdit.putString("string", "this is string value")
            preferenceEdit.apply()
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()

        }
        btnActivityData.setOnClickListener {
            val preference = getPreferences(Context.MODE_PRIVATE)
            val intValue = preference.getBoolean("boolean", false)
            val stringValue = preference.getString("string", "ssss")
            btnActivityData.setText("age is $intValue, name value is$stringValue")

        }

        btnContext.setOnClickListener {
            val preference = getSharedPreferences("sharepreference", Context.MODE_PRIVATE)
            val preferenceEdit = preference.edit()
            preferenceEdit.putInt("int", 26)
            preferenceEdit.putString("string", "this is string value")
            preferenceEdit.apply()
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()

        }
        btnContextData.setOnClickListener {
            val preference = getSharedPreferences("sharepreference", Context.MODE_PRIVATE)
            val intValue = preference.getInt("int", 0)
            val stringValue = preference.getString("string", "ssss")
            btnContextData.setText("age is $intValue, name value is$stringValue")
        }
    }
}