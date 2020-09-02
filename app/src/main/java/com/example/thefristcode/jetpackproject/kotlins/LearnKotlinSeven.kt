package com.example.thefristcode.jetpackproject.kotlins

import kotlin.reflect.KProperty

class MyClass<T> {
    fun method(param: T): T {
        return param

    }
}

class MyTestClass {
    //通过继承为范型指定上界
    fun <T : Number> method(param: T): T {
        return param
    }
}

class MyTestClassTwo() {
    var p by Delegate()
}

class Delegate {
    var property: Any? = null

    operator fun getValue(myTestClassTwo: MyTestClassTwo, pro: KProperty<*>): Any? {
        return property
    }

    operator fun setValue(myTestClassTwo: MyTestClassTwo, pro: KProperty<*>, value: Any?) {

        property = value
    }
}

fun StringBuilder.build(block: java.lang.StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}


fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}

class MySet<T>(val helperSet: HashSet<T>) : Set<T> {

    override val size: Int get() = helperSet.size

    override fun contains(element: T) = helperSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)

    override fun isEmpty() = helperSet.isEmpty()

    override fun iterator() = helperSet.iterator()
}


class MySetTwo<T>(val helperSet: HashSet<T>) : Set<T> by helperSet {

    fun helloworld() = println("hello wrold")

    override fun isEmpty() = false

}

fun main() {
    val param1 = MyClass<Int>()
    val param2 = MyTestClass()
    val result1 = param1.method(123)
    val result2 = param2.method(234)
    println("this is $result1")
    println("this is $result2")

    result1.build {
        println("$result1+123123")
    }

}