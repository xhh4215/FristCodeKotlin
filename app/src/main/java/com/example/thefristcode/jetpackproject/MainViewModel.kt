package com.example.thefristcode.jetpackproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {
    private val userLiveData = MutableLiveData<User>()

    //  map 方法是对LiveData内部的数据类型进行转化的
    // switchMap 是对观察的livedata对象进行切换的
    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
        "${user.fristName}${user.lastName}"
    }
    val counter: LiveData<Int>
        get() = _counter
    private val _counter = MutableLiveData<Int>()


    init {
        _counter.value = countReserved
    }


    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }


    fun clear() {
        _counter.value = 0
    }
}