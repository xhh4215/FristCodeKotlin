package com.example.thefristcode.jetpackproject.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.thefristcode.jetpackproject.R

class MenuActivity : AppCompatActivity() {

    var name: String? = "age"
    var age: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        name = intent.getStringExtra("name")
        age = intent.getIntExtra("age", 0)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.the_frist_menu, menu)
        //返回值表示是否让菜单显示出来
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.age -> {
                Toast.makeText(this, "this is $age", Toast.LENGTH_SHORT).show()
            }
            R.id.name -> {
                Toast.makeText(this, "this is $name", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

}