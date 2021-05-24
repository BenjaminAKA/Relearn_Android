package com.pengkai.example.jpusjmodule.jpush

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import cn.jpush.android.api.JPushInterface

/**
 * author: pengkai
 * created on: 2021/5/24 3:06 下午
 * description:
 */
class MyMessageReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras
        when (intent?.action) {
            //注册所得到的注册id/
            JPushInterface.ACTION_REGISTRATION_ID -> {

            }
            //收到了自定义消息 Push。
            JPushInterface.ACTION_MESSAGE_RECEIVED -> {
                //保存服务器推送下来的消息的标题。
                val title = bundle?.getString(JPushInterface.EXTRA_TITLE)
                //保存服务器推送下来的消息内容。
                val message = bundle!!.getString(JPushInterface.EXTRA_MESSAGE)
                //保存服务器推送下来的附加字段。这是个 JSON 字符串。
                val extras = bundle.getString(JPushInterface.EXTRA_EXTRA)
                //唯一标识消息的 ID, 可用于上报统计等。
                val file = bundle.getString(JPushInterface.EXTRA_MSG_ID)
            }
            //收到了通知 Push。
            JPushInterface.ACTION_NOTIFICATION_RECEIVED -> {
                //保存服务器推送下来的通知的标题
                val title = bundle!!.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE)
                //保存服务器推送下来的通知内容。
                val content = bundle.getString(JPushInterface.EXTRA_ALERT)
                //保存服务器推送下来的附加字段。这是个 JSON 字符串
                val extras = bundle.getString(JPushInterface.EXTRA_EXTRA)
                //通知栏的 Notification ID，可以用于清除 Notification
                val notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID)
//                //富媒体通知推送下载的 HTML 的文件路径，用于展现 WebView。
//                val fileHtml = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_PATH)
//                //富媒体通知推送下载的图片资源的文件名，多个文件名用 “，” 分开。与 “JPushInterface.EXTRA_RICHPUSH_HTML_PATH” 位于同一个路径。
//                val fileStr = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_RES)
//                val fileNames = fileStr!!.split(",").toTypedArray()
//                //唯一标识通知消息的 ID，可用于上报统计等。
//                val file = bundle.getString(JPushInterface.EXTRA_MSG_ID)
//                //大文本通知样式中大文本的内容。
//                val bigText = bundle.getString(JPushInterface.EXTRA_BIG_TEXT)
//                //可支持本地图片的路径，或者填网络图片地址。
//                val bigPicPath = bundle.getString(JPushInterface.EXTRA_BIG_PIC_PATH)
//                //获取的是一个 JSONObject，json 的每个 key 对应的 value 会被当作文本条目逐条展示。收件箱通知样式中收件箱的内容。
//                val inboxJson = bundle.getString(JPushInterface.EXTRA_INBOX)
//                //默认为 0，范围为 -2～2，其他值将会被忽略而采用默认。通知的优先级
//                val prio = bundle.getString(JPushInterface.EXTRA_NOTI_PRIORITY)

                Log.e("MyMessageReceiver", "ACTION_NOTIFICATION_RECEIVED title:$title")
                Log.e("MyMessageReceiver", "ACTION_NOTIFICATION_RECEIVED content:$content")
                Log.e("MyMessageReceiver", "ACTION_NOTIFICATION_RECEIVED extras:$extras")
                Log.e(
                    "MyMessageReceiver",
                    "ACTION_NOTIFICATION_RECEIVED notificationId:$notificationId"
                )
            }
            /**
             * 用户点击了通知。 一般情况下，用户不需要配置此 receiver action。
             *如果开发者在 AndroidManifest.xml 里未配置此 receiver action，
             * 那么，SDK 会默认打开应用程序的主 Activity，相当于用户点击桌面图标的效果。
             *如果开发者在 AndroidManifest.xml 里配置了此 receiver action，
             * 那么，当用户点击通知时，SDK 不会做动作。开发者应该在自己写的 BroadcastReceiver 类里处理，
             * 比如打开某 Activity 。
             */
            JPushInterface.ACTION_NOTIFICATION_OPENED -> {
                //保存服务器推送下来的通知的标题。
                val title = bundle!!.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE)
                //保存服务器推送下来的通知内容。
                val content = bundle.getString(JPushInterface.EXTRA_ALERT)
                //保存服务器推送下来的附加字段。这是个 JSON 字符串。
                val type = bundle.getString(JPushInterface.EXTRA_EXTRA)
                //通知栏的 Notification ID，可以用于清除 Notification
                val notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID)
                //唯一标识调整消息的 ID，可用于上报统计等。
                val file = bundle.getString(JPushInterface.EXTRA_MSG_ID)
            }

            JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION -> {

            }
        }
    }
}