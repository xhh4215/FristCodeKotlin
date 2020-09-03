package com.example.thefristcode.jetpackproject.kotlins

inline fun <reified T> getGenericType() = T::class.java
fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1 ")
    println("result2 is $result2 ")
}


open class Personal(val name: String, val age: Int)
class Students(name: String, age: Int) : Personal(name, age)
class Teachers(name: String, age: Int) : Personal(name, age)