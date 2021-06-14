package com.example.jetpackmodule

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackmodule.databinding.ActivityLiveDataSampleBinding

class LiveDataSampleActivity : AppCompatActivity() {

    private val mBinding: ActivityLiveDataSampleBinding by lazy {
        ActivityLiveDataSampleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }

    companion object {
        /**
         * 吊起方法
         *
         */
        fun start(context: Context) {
            context.startActivity(Intent(context, LiveDataSampleActivity::class.java))
        }
    }
}