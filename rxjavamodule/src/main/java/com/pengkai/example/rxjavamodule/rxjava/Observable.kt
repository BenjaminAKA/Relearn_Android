package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 10:05 上午
 * description:被观察者核心抽象类
 */
abstract class Observable<T> : ObservableSource<T> {
    override fun subscribe(observer: Observer<T>) {
        subscribeActual(observer)
    }

    abstract fun subscribeActual(observer: Observer<T>)

    companion object {
        fun <T> create(observableOnSubscribe: ObservableOnSubscribe<T>): Observable<T> {
            return ObservableCreate(observableOnSubscribe)
        }
    }
}