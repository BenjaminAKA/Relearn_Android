package com.example.jetpackmodule.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UpDownViewModel : ViewModel() {
    private val progress: MutableLiveData<Int> = MutableLiveData()

    fun getProgress(): MutableLiveData<Int> {
        if (progress.value == null) {
            progress.value = 0
        }
        return progress
    }
}