package com.pengkai.example.rxjavamodule.data

/**
 * author: pengkai
 * created on: 2021/5/19 4:00 下午
 * description:学生类
 */
class Student {
    var name:String?=null//姓名
    var courseList:List<Course> = emptyList()//课程列表

    //课程类
    class Course{
        var courseName:String?=null
        override fun toString(): String {
            return "Course(courseName=$courseName)"
        }
    }

    override fun toString(): String {
        return "Student(name=$name, courseList=$courseList)"
    }
}
