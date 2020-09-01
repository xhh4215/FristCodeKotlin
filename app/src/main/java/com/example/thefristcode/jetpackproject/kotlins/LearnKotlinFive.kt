package com.example.thefristcode.jetpackproject.kotlins

inline fun num1Andnum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val resut = operation(num1, num2)
    return resut
}

fun plus(num1: Int, num2: Int) = num1 + num2

fun mius(num1: Int, num2: Int) = num1 - num2


fun main() {
    val num1 = 100
    val num2 = 80
    val resut1 = num1Andnum2(num1,num2,::plus)
    val resut3 = num1Andnum2(num1,num2){n1,n2->n1+n2}
    val resut2 = num1Andnum2(num1,num2,::mius)
    val resut4 = num1Andnum2(num1,num2){n1,n2->n1-n2}
    println("result1 is $resut1")
    println("result2 is $resut2")
    println("result3 is $resut3")
    println("result4 is $resut4")
}