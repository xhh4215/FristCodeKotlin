package com.example.thefristcode.jetpackproject

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.example.thefristcode.jetpackproject.sqlites.MyDataBaseOpenHelper

/****
 * @author lmg
 *
 * @data 2020年 9月 2日
 *
 * @use 这是一个ContentProvider实现的是跨进程的通信
 */
class DatabaseProvider : ContentProvider() {
    // 操作整个Book表
    private val bookDir = 0

    // 操作Book表的单行数据
    private val bookItem = 1

    // 操作整个 Category表
    private val categoryDir = 2

    // 操作Category表的单行数据
    private val categoryItem = 3

    //
    private val authority = "com.example.databasetest.provider"

    // 本地的SqlLite数据库对象
    private var dbHelper: MyDataBaseOpenHelper? = null

    /**
     *  创建 uriMatcher 对象 向内部添加uri对象
     */
    private val uriMatcher by lazy {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI(authority, "book", bookDir)
        matcher.addURI(authority, "book/#", bookItem)
        matcher.addURI(authority, "category", categoryDir)
        matcher.addURI(authority, "category/#", categoryItem)
        matcher
    }

    /***
     * ContentProvider首次创建的时候调用的方法
     */
    override fun onCreate() = context?.let {
        // ?. 如果对象不为空就执行调用的逻辑
        dbHelper = MyDataBaseOpenHelper(it, "Book.db", 3)
        true
    } ?: false

    /****
     * 删除数据的方法
     */
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) =
        dbHelper?.let {
            // 获取操作数据库的对象
            val db = it.writableDatabase
            // 删除的列
            val deleteRows =
                // 匹配对应uri对对应的表进行操作
                when (uriMatcher.match(uri)) {
                    bookDir -> {
                        //操作Book数据表
                        db.delete("Book", selection, selectionArgs)
                    }
                    bookItem -> {
                        //获取匹配的uri中的bookId
                        val bookId = uri.pathSegments[1]
                        //操作Book数据表的bookId行的数据
                        db.delete("Book", "id=?", arrayOf(bookId))
                    }
                    //操作Categroy数据表
                    categoryDir -> {
                        //删除category数据表
                        db.delete("Category", selection, selectionArgs)
                    }
                    categoryItem -> {
                        val categoryId = uri.pathSegments[1]
                        db.delete("Category", "id=?", arrayOf(categoryId))
                    }
                    else -> 0

                }
            //返回删除的数据列
            deleteRows

        } ?: 0


    override fun getType(uri: Uri) = when (uriMatcher.match(uri)) {
        bookItem -> "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.book"
        bookDir -> "vnd.android.cursor.item/vnd.com.example.databasetest.provider.book"
        categoryItem -> "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.category"
        categoryDir -> "vnd.android.cursor.dir/vnd.com.example.databasetest.provider.category"
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper?.let {
        val db = it.writableDatabase
        val uriReturn = when (uriMatcher.match(uri)) {
            bookItem, bookDir -> {
                val newBook = db.insert("Book", null, values)
                Uri.parse("content://$authority/book/$newBook")
            }
            categoryItem, categoryDir -> {
                val newCategory = db.insert("Category", null, values)
                Uri.parse("content://$authority/category/$newCategory")

            }
            else -> null
        }

        uriReturn
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ) = dbHelper?.let {
        val db = it.readableDatabase
        val cursor = when (uriMatcher.match(uri)) {
            bookDir -> {
                db.query("Book", projection, selection, selectionArgs, null, null, sortOrder)

            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.query("Book", selectionArgs, "id=?", arrayOf(bookId), null, null, sortOrder)

            }
            categoryDir -> {
                db.query("Category", projection, selection, selectionArgs, null, null, sortOrder)

            }
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.query("Book", selectionArgs, "id=?", arrayOf(categoryId), null, null, sortOrder)
            }

            else -> null
        }
        cursor
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ) = dbHelper?.let {
        val db = it.writableDatabase
        val updateRows = when (uriMatcher.match(uri)) {
            bookDir -> {
                db.update("Book", values, selection, selectionArgs)
            }
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.update("Book", values, "id=?", arrayOf(bookId))
            }

            categoryDir -> {
                db.update("Category", values, selection, selectionArgs)
            }
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.update("Category", values, "id=?", arrayOf(categoryId))
            }
            else -> 0

        }
        updateRows

    } ?: 0
}
