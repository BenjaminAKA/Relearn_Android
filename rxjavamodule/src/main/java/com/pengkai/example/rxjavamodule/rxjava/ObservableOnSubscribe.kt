package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 10:08 上午
 * description:订阅关系类
 */
interface ObservableOnSubscribe<T> {
    fun subscribe(emitter: Emitter<T>)
}