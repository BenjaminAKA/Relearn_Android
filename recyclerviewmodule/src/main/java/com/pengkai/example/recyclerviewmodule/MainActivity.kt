package com.pengkai.example.recyclerviewmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pengkai.example.recyclerviewmodule.adapter.MemberAdapter
import com.pengkai.example.recyclerviewmodule.bean.MemberInfo
import com.pengkai.example.recyclerviewmodule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mAdapter: MemberAdapter by lazy {
        MemberAdapter()
    }

    private var mData: MutableList<MemberInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initView()
        initListener()
    }

    private fun initListener() {
        mBinding.btnAdd.setOnClickListener {
            val data = MemberInfo()
            mData.add(data)
            mAdapter.notifyItemInserted(mData.size-1)
        }

        mAdapter.setOnItemChildClickListener { _, view, position ->
            when(view.id){
                R.id.btn_remove->{
                    Toast.makeText(this,"index:$position",Toast.LENGTH_SHORT).show()
                    mData.removeAt(position)
                    mAdapter.notifyItemRemoved(position)
                }
            }
        }
    }

    private fun initView() {
        mBinding.rvContent.apply {
            isNestedScrollingEnabled = false
            adapter = mAdapter
            mAdapter.setNewInstance(mData)
            recycledViewPool.setMaxRecycledViews(0,0)
        }
    }
}