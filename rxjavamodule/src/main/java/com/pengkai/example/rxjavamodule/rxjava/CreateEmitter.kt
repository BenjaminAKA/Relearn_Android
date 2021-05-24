package com.pengkai.example.rxjavamodule.rxjava

/**
 * author: pengkai
 * created on: 2021/5/20 10:02 上午
 * description:发射器实现类
 */
class CreateEmitter<T>(private var observer: Observer<T>) : Emitter<T> {

    var done: Boolean = false

    override fun onNext(t: T) {
        if (done) return
        observer.onNext(t)
    }

    override fun onError(throwable: Throwable) {
        if (done) return
        observer.onError(throwable)
        done=true
    }

    override fun onComplete() {
        if (done) return
        observer.onComplete()
        done=true
    }
}