package com.pengkai.example.jpusjmodule

import android.app.Application
import cn.jpush.android.api.JPushInterface
import com.pengkai.example.jpusjmodule.jpush.JPushManager

/**
 * author: pengkai
 * created on: 2021/5/21 5:36 下午
 * description:
 */
class MyApplication:Application(){
    override fun onCreate() {
        super.onCreate()
       JPushManager.instance.init(this)
    }
}