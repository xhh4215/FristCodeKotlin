package com.example.thefristcode.jetpackproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainModelFactory(private val countResvered: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(countResvered) as T
    }

}