package com.pengkai.example.rxjavamodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pengkai.example.rxjavamodule.databinding.ActivityMainBinding
import com.pengkai.example.rxjavamodule.demo.MapFunctionDemo.Companion.useFlatMap
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useBuffer
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useCompose
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useConcat
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useConcatArray
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useFilter
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useMergeArray
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useMyRxJava
import com.pengkai.example.rxjavamodule.demo.RxFunctionDemo.Companion.useThreadSwitch
import com.pengkai.example.rxjavamodule.utils.ViewUtils.onClick

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        mBinding.apply {
            btnUseBuffer.onClick { useBuffer() }

            btnUseCompose.onClick { useCompose() }

            btnUseConcat.onClick { useConcat() }

            btnUseConcatArray.onClick { useConcatArray() }

            btnUseMergeArray.onClick { useMergeArray() }

            btnUseThreadSwitch.onClick { useThreadSwitch() }

            btnUseFilter.onClick { useFilter() }

            btnUseFlatmap.onClick {
                useFlatMap()
            }

            btnUseMyRxjava.onClick {
                useMyRxJava()
            }
        }
    }
}