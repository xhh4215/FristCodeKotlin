package com.example.thefristcode.jetpackproject.kotlins

import android.content.Context
import android.content.SharedPreferences

/****
 * 这个高阶函数的意思是在lambda表达式的内部必须通过String来调用这个
 * 高阶函数
 */
fun String.open(block: String.(value: String) -> Unit) {
    this.block(this)
}

/****
 * 这个高阶函数的意思是在lambda内部可以随便的执行这个高阶函数
 */
fun String.open(block: (value: String) -> Unit) {
    block(this)
}

/***
 * 现在写一个Sharepreference的扩展函数
 */
fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}

