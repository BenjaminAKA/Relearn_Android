package com.pengkai.example.jpusjmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.jpush.android.api.JPushInterface

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JPushInterface.requestPermission(this)
    }
}