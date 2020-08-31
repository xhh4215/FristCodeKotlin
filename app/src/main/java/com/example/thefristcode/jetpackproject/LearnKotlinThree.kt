package com.example.thefristcode.jetpackproject

import java.lang.StringBuilder

fun main() {
    //with函数的使用

//    val builder = StringBuilder()
//    builder.append("start eating fruits.\n")
//
//    for (fruit in list) {
//        builder.append(fruit).append("\n")
//    }
//    builder.append("eat all fruit.")
//    val result = builder.toString()
//    println(result)

    val list = listOf("apple", "banana", "orange", "pear", "grape")
    //with 函数的使用
    val result = with(StringBuilder()) {
        append("start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("eat all fruit.")
        toString()
    }
    println(result)
    // run函数的使用  必须调用的是某个对象的run 函数
    //lambda表达式内部持有该对象的上下文
    StringBuilder().run {
        append("start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("eat all fruit.")
        toString()
    }
    //apply函数的使用 他和run函数使用的方式差不多 也是作用在一个对象上
    //在lambda内部持有该对象的上下文
    //只不过他无法指定返回的数据类型  而是返回对象自己
    //kotlin中的顶层方法默认是静态的
}