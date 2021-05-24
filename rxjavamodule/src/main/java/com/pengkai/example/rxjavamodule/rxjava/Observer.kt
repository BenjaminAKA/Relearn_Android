package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 9:58 上午
 * description:观察者顶层接口
 */
interface Observer<T> {
    fun onSubscribe()

    fun onNext(t: T)

    fun onError(throwable: Throwable)

    fun onComplete();
}