package com.example.jetpackmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackmodule.databinding.ActivityMainBinding
import com.example.jetpackmodule.viewmodel.MyViewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mModel: MyViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(
            MyViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mModel.getCurrentSecond().observe(this,
            { t -> mBinding.tvCurrentSecond.text = t.toString() })
        startTimer()

        mBinding.btnJumpLivedata.setOnClickListener {
            LiveDataSampleActivity.start(this)
        }
    }

    private fun startTimer() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                mModel.getCurrentSecond().postValue(mModel.getCurrentSecond().value?.plus(1))
            }
        }, 1000, 1000)
    }
}