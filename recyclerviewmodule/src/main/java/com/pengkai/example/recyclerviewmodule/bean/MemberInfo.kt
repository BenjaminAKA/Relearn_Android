package com.pengkai.example.recyclerviewmodule.bean

import java.io.Serializable

/**
 * author: pengkai
 * created on: 2021/5/31 9:42 上午
 * description:成员类
 */
class MemberInfo : Serializable {
    var index:Int=0
    var name: String? = null//姓名
    var tel: String? = null//电话
}