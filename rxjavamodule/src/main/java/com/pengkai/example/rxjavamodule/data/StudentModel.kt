package com.pengkai.example.rxjavamodule.data

/**
 * author: pengkai
 * created on: 2021/5/19 4:04 下午
 * description:
 */
class StudentModel {
    companion object{
        var students:ArrayList<Student> = ArrayList()
        fun init(){
            for (i in 0..10){
                val student=Student()
                val courseList:ArrayList<Student.Course> = ArrayList()
                for (j in 0..10){
                    val course:Student.Course= Student.Course()
                    course.courseName="courseName$j"
                    courseList.add(course)
                }
                student.courseList=courseList
                students.add(student)
            }
        }
    }
}