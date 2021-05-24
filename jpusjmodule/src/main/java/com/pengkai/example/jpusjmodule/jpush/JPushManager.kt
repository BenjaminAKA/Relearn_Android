package com.pengkai.example.jpusjmodule.jpush

import android.content.Context
import cn.jpush.android.api.JPushInterface

/**
 * author: pengkai
 * created on: 2021/5/24 3:05 下午
 * description:JPushManager
 */
class JPushManager {
    companion object {
        val instance: JPushManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            JPushManager()
        }
    }

    /**
     * 初始化
     */
    fun init(context: Context) {
        JPushInterface.setDebugMode(true)
        JPushInterface.init(context)
    }

    /**
     * 调用了本 API 后，JPush 推送服务完全被停止。具体表现为：
     * 收不到推送消息
     * 极光推送所有的其他 API 调用都无效，不能通过 JPushInterface.init 恢复，需要调用 resumePush 恢复。
     */
    fun stopPush(context: Context) {
        JPushInterface.stopPush(context)
    }

    /**
     * 恢复推送服务。
     * 调用了此 API 后，极光推送完全恢复正常工作
     */
    fun resumePush(context: Context) {
        JPushInterface.resumePush(context)
    }

    /**
     * 用来检查 Push Service 是否已经被停止
     */
    fun isPushStop(context: Context): Boolean {
        return JPushInterface.isPushStopped(context)
    }

    /**
     * 设置别名
     *
     * @param sequence:用户自定义的操作序列号，同操作结果一起返回，用来标识一次操作的唯一性，推荐每次都用不同的数字序号。
     * @param alias:每次调用设置有效的别名，覆盖之前的设置。
     */
    fun setAlias(context: Context, sequence: Int, alias: String) {
        JPushInterface.setAlias(context, sequence, alias)
    }

}