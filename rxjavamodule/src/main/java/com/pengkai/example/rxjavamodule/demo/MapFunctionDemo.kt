package com.pengkai.example.rxjavamodule.demo

import com.pengkai.example.rxjavamodule.data.StudentModel
import io.reactivex.rxjava3.core.Observable

/**
 * author: pengkai
 * created on: 2021/5/19 3:01 下午
 * description:MapFunctionDemo
 */
class MapFunctionDemo {
    companion object{
        fun useFlatMap(){
            StudentModel.init()
            Observable.fromIterable(StudentModel.students).flatMap {
                Observable.fromIterable(it.courseList)
            }.map {
                it.courseName="CourseName------>${it.courseName}"
                it
            }.subscribe {
                println(it.toString())
            }
        }
    }
}