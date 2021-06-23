package com.example.jetpackmodule.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    private  val currentSecond:MutableLiveData<Int> = MutableLiveData()

    fun getCurrentSecond():MutableLiveData<Int>{
        if (currentSecond.value==null){
            currentSecond.value=0
        }
        return currentSecond
    }
}