package com.pengkai.example.videomodule

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.pengkai.example.videomodule.databinding.ActivityMainBinding
import com.pengkai.example.videomodule.exoplayer.GSYExo2PlayerView
import com.pengkai.example.videomodule.exoplayer.GSYExoVideoManager
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.model.GSYVideoModel
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import java.util.*
import kotlin.collections.ArrayList


open class MainActivity : GSYBaseActivityDetail<GSYExo2PlayerView>() {

    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initVideo()
        val urls: ArrayList<GSYVideoModel> = ArrayList()
        initData(urls)
        mBinding.playerExo.apply {
            setUp(urls, 0)
            setExoCache(false)
//            overrideExtension = "m3u8"
            //增加封面
            val imageView = ImageView(this@MainActivity)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setBackgroundResource(R.color.black)
            thumbImageView = imageView

            resolveNormalVideoUI()

            setIsTouchWiget(true)
            //关闭自动旋转
            //关闭自动旋转
            isRotateViewAuto = false
            isLockLand = false
            isShowFullAnimation = false
            isNeedLockFull = true
            setVideoAllCallBack(this@MainActivity)
            setLockClickListener { view, lock ->
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.isEnable = !lock
                }
            }
        }

        mBinding.next.setOnClickListener {
            GSYExoVideoManager.instance().next()
            (mBinding.playerExo.getCurrentPlayer() as GSYExo2PlayerView).nextUI()
        }
    }

    override fun onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo()
        }
        if (GSYExoVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }

    private fun initData(urls: ArrayList<GSYVideoModel>) {
        urls.add(
            GSYVideoModel(
                "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4",
                "标题1"
            )
        )
        urls.add(GSYVideoModel("https://media6.smartstudy.com/ae/07/3997/2/dest.m3u8", "标题3"))
        urls.add(
            GSYVideoModel(
                "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4",
                "标题2"
            )
        )
    }

    override fun getGSYVideoPlayer(): GSYExo2PlayerView {
        return mBinding.playerExo
    }

    override fun getGSYVideoOptionBuilder(): GSYVideoOptionBuilder? {
        return null
    }

    override fun clickForFullScreen() {

    }

    override fun getDetailOrientationRotateAuto(): Boolean {
        return true
    }

    override fun onEnterFullscreen(url: String?, vararg objects: Any?) {
        super.onEnterFullscreen(url, *objects)
        //隐藏调全屏对象的返回按键
        //隐藏调全屏对象的返回按键
        val gsyVideoPlayer = objects[1] as GSYVideoPlayer
        gsyVideoPlayer.backButton.visibility = View.GONE
    }

    private fun resolveNormalVideoUI() {
        //增加title
        mBinding.playerExo.titleTextView.visibility = View.VISIBLE
        mBinding.playerExo.backButton.visibility = View.VISIBLE
    }
}