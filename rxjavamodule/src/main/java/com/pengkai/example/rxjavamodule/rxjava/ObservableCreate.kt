package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 10:10 上午
 * description:被观察者实现类
 */
class ObservableCreate<T>(private var source: ObservableOnSubscribe<T>) : Observable<T>() {
    override fun subscribeActual(observer: Observer<T>) {
        observer.onSubscribe()
        val emitter: CreateEmitter<T> = CreateEmitter<T>(observer)
        source.subscribe(emitter)
    }
}