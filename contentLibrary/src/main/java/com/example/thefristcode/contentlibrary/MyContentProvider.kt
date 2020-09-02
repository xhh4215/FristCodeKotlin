package com.example.thefristcode.contentlibrary

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

class MyContentProvider : ContentProvider() {
    private val tableDir = 0
    private val tableItem = 1
    private val table2Dir = 2
    private val table2Item = 3


    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)


    init {
        uriMatcher.addURI("com.example.thefristcode.jetpackproject", "table1", tableDir)
        uriMatcher.addURI("com.example.thefristcode.jetpackproject", "table2", table2Dir)
        uriMatcher.addURI("com.example.thefristcode.jetpackproject", "table1/#", tableItem)
        uriMatcher.addURI("com.example.thefristcode.jetpackproject", "table2/#", table2Item)
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        TODO("Not yet implemented")
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        TODO("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    override fun getType(p0: Uri): String? {
        TODO("Not yet implemented")
    }

}