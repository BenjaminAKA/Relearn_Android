package com.pengkai.example.rxjavamodule.utils

import android.view.View
import com.jakewharton.rxbinding4.view.clicks
import java.util.concurrent.TimeUnit

/**
 * author: pengkai
 * created on: 2021/5/19 9:10 上午
 * description:ViewUtils
 */
object ViewUtils {
    fun View.onClick(onClick: () -> Unit) {
        clicks().throttleFirst(1, TimeUnit.SECONDS).subscribe { onClick.invoke() }
    }
}