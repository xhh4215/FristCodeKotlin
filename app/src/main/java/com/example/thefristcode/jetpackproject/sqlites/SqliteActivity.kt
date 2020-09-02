package com.example.thefristcode.jetpackproject.sqlites

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.thefristcode.jetpackproject.R
import kotlinx.android.synthetic.main.activity_sqlite.*
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.reflect.Executable

class SqliteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        //创建数据库
//        val dbHelper = MyDataBaseOpenHelper(this, "Book.db", 1)
        val dbHelper = MyDataBaseOpenHelper(this, "Book.db", 2)

        createBook.setOnClickListener {
            dbHelper.readableDatabase
        }
        //添加数据
        addData.setOnClickListener {
            Toast.makeText(this, "添加数据", Toast.LENGTH_SHORT).show()
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name", "成功是怎么到来的")
                put("author", "栾桂明")
                put("pages", 345)
                put("price", 16.45)
            }
            db.insert("Book", null, value1)
            val value2 = ContentValues().apply {
                put("name", "成功是怎么到来的")
                put("author", "栾桂明")
                put("pages", 345)
                put("price", 16.45)
            }
            try {
                db.insert("Book", null, value2)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        //更新数据
        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price", 100)
            db.update("Book", values, "name=?", arrayOf("成功是怎么到来的"))
        }
        //删除数据
        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book", "pages>?", arrayOf("300"))
        }
        //查询数据
        queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book", null, null, null, null, null, null)
            val isfrist = cursor.moveToFirst()
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("lgm", "name :$name")
                    Log.d("lgm", "author :$author")
                    Log.d("lgm", "pages :$pages")
                    Log.d("lgm", "price :$price")

                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        tranactionData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction()
            try {
                db.delete("Book", null, null)
                if (true) {
                    throw NullPointerException()
                }
                val value1 = ContentValues().apply {
                    put("name", "成功是怎么到来的")
                    put("author", "栾桂明")
                    put("pages", 345)
                    put("price", 16.45)
                }
                db.insert("Book", null, value1)
                db.setTransactionSuccessful()

            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}
