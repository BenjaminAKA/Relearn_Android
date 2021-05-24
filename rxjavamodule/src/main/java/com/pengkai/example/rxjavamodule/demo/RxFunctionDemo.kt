package com.pengkai.example.rxjavamodule.demo

import android.util.Log
import com.pengkai.example.rxjavamodule.rxjava.Emitter
import com.pengkai.example.rxjavamodule.rxjava.ObservableOnSubscribe
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * author: pengkai
 * created on: 2021/5/19 10:32 上午
 * description:
 */
class RxFunctionDemo {
    companion object {
        fun useBuffer() {
            //将事件分配发射
            Observable.just("Event1", "Event2", "Event3", "Event4", "Event5", "Event6").buffer(2)
                .subscribe {
                    Log.e("useBuffer", it.toString())
                }
        }

        fun useCompose() {
            Observable.just("Hello Rx").compose {
                Observable.just(it)
            }.subscribe {
                Log.e("useCompose", it.toString())
            }
        }

        fun useConcat() {
            //concat 将传入的被观察者列表打包成一个新的观察者进行订阅,concat最多发送4个事件
            //发送事件是串行发送
            Observable.concat(
                Observable.just("Event1"),
                Observable.just("Event2"),
                Observable.just("Event3"),
                Observable.just("Event4"),
            ).subscribe {
                Log.e("useConcat", it.toString())
            }
        }

        fun useConcatArray() {
            //concatArray 将传入的被观察者列表打包成一个新的观察者进行订阅,与concat不同的是concatArray可以发送超过4个事件
            //发送事件是串行发送
            Observable.concatArray(
                Observable.just("Event1"),
                Observable.just("Event2"),
                Observable.just("Event3"),
                Observable.just("Event4"),
                Observable.just("Event5"),
            ).subscribe {
                Log.e("useConcat", it.toString())
            }
        }

        fun useMergeArray() {
            //mergeArray 将传入的被观察者列表打包成一个新的观察者进行订阅,与merge不同的是mergeArray可以发送超过4个事件
            //发送事件是并行发送
            Observable.mergeArray(
                Observable.just("Event1"),
                Observable.just("Event2"),
                Observable.just("Event3"),
                Observable.just("Event4"),
                Observable.just("Event5"),
            ).subscribe {
                Log.e("useConcat", it.toString())
            }
        }

        fun useThreadSwitch() {
            Observable.create<Any> {
                println("subscribe" + Thread.currentThread())
                it.onNext("Event1")
                it.onComplete()
            }.doOnNext {
                println("doOnNext" + Thread.currentThread())
            }.doAfterNext {
                println("doAfterNext" + Thread.currentThread())
            }.doOnEach {
                println("doOnEach" + Thread.currentThread())
            }.subscribeOn(Schedulers.newThread())//主要用来决定上游subscribe方法所处的线程，也就是产生事件发射事件所在的线程。
                .observeOn(Schedulers.io())//来决定下游事件被处理时所处的线程，其实现原理给予Handler
                .map {
                    println("map apply" + Thread.currentThread())
                    "bbb"
                }.observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Any> {
                    override fun onSubscribe(d: Disposable?) {
                        println("onSubscribe" + Thread.currentThread())
                    }

                    override fun onNext(t: Any?) {
                        println("onNext${Thread.currentThread()}")
                        println("onNext${t.toString()}")
                    }

                    override fun onError(e: Throwable?) {
                        println("onError" + Thread.currentThread())
                    }

                    override fun onComplete() {
                        println("onComplete" + Thread.currentThread())
                    }
                })
        }

        /**
         * 过滤操作符
         */
        fun useFilter() {
            //range:发送一定范围的事件序列
            Observable.range(1, 10).filter {
                //满足filter条件的事件都会被过滤掉，满足返回false，被过滤，不满足返回true。
                it < 5
            }.subscribe {
                println("onNext：$it")
            }
        }

        fun useMyRxJava() {
            com.pengkai.example.rxjavamodule.rxjava.Observable.create(object :
                ObservableOnSubscribe<Any> {
                override fun subscribe(emitter: Emitter<Any>) {
                    emitter.onNext("Event1")
                    emitter.onNext("Event2")
                    emitter.onNext("Event3")
                    emitter.onError(Throwable("Error"))
                    emitter.onComplete()
                }
            }).subscribe(object : com.pengkai.example.rxjavamodule.rxjava.Observer<Any> {
                override fun onSubscribe() {
                    println("onSubscribe")
                }

                override fun onNext(t: Any) {
                    println("onNext:$t")
                }

                override fun onError(throwable: Throwable) {
                    println("onError:${throwable.message}")
                }

                override fun onComplete() {
                    println("onComplete")
                }

            })

        }
    }
}