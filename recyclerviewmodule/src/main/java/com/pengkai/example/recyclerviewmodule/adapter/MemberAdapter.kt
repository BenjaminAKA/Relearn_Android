package com.pengkai.example.recyclerviewmodule.adapter

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.pengkai.example.recyclerviewmodule.R
import com.pengkai.example.recyclerviewmodule.bean.MemberInfo

/**
 * author: pengkai
 * created on: 2021/5/31 9:45 上午
 * description:
 */
class MemberAdapter : BaseQuickAdapter<MemberInfo, BaseViewHolder>(R.layout.layout_member_itrem) {

    init {
        addChildClickViewIds(R.id.btn_remove)
    }

    override fun convert(holder: BaseViewHolder, item: MemberInfo) {
        val edName = holder.getView<EditText>(R.id.ed_name)
        val edTel = holder.getView<EditText>(R.id.ed_tel)

        val nameTextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                //这里处理数据
                if (!TextUtils.isEmpty(s.toString())) {
                    item.name = s.toString()
                }
            }
        }

        val telTextWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                //这里处理数据
                if (!TextUtils.isEmpty(s.toString())) {
                    item.tel = s.toString()
                }
            }
        }

        edName.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                edName.addTextChangedListener(nameTextWatcher)
            } else {
                edName.removeTextChangedListener(nameTextWatcher)
            }
        }

        edTel.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                edTel.addTextChangedListener(telTextWatcher)
            } else {
                edTel.removeTextChangedListener(telTextWatcher)
            }
        }
    }
}