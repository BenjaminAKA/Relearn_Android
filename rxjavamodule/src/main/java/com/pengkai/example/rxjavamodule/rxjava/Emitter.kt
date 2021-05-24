package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 10:01 上午
 * description:发射器顶层接口
 */
interface Emitter<T> {
    fun onNext(t:T)

    fun onError(throwable: Throwable)

    fun onComplete()
}