package com.example.thefristcode.jetpackproject.kotlins

import java.lang.Exception
sealed class Resut

class Success(val msg: String) : Resut()
class Failure(val error: Exception) : Resut()


fun getResultMsg(resut: Resut) = when (resut) {
    is Success -> resut.msg
    is Failure -> resut.error.message

}


fun main() {

}