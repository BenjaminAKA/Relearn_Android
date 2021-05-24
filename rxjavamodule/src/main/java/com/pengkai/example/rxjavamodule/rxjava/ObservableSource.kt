package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 9:57 上午
 * description:
 */
interface ObservableSource<T> {
    /**
     * 添加被观察者
     * @param observer
     */
    fun subscribe(observer: Observer<T>)
}