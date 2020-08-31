package com.example.thefristcode.jetpackproject

fun main() {
    val student = Student("栾桂明", 12)

}


class Student(val name: String, val age: Int) {
    // kotlin 中所有的次要构造器都必须调用主构造器来初始化
    constructor(name: String, age: Int, gender: Int) : this(name, age)

    constructor(name: String, age: Int, gender: Int, parent: String) : this(name, age, gender)

    //可以在init初始化块中对进行主构造器的初始化操作
    init {
        println("name:$name,age$age")
    }
}