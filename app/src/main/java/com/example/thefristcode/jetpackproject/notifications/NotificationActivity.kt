package com.example.thefristcode.jetpackproject.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.thefristcode.jetpackproject.R
import com.example.thefristcode.jetpackproject.permisssiongs.PermissionActivity
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            val channel2 =
                NotificationChannel("important", "Important", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }

        createNotification.setOnClickListener {
            val intent = Intent(this, PermissionActivity::class.java)
            val pi = PendingIntent.getActivity(this, 0, intent, 0)
            val notification = NotificationCompat.Builder(this, "important")
                .setContentTitle("this is content title")
//                .setContentText("this is content text")
                    //setStyle()用于在通知中显示大量的文字信息
//                .setStyle(NotificationCompat.BigTextStyle().bigText("欢迎使用 Android 开发者指南。借助左侧导航中所列文档，您可以了解如何使用 Android 框架和其他库中的 API 构建 Android 应用。\n" +
//                        "\n" +
//                        "如果您是首次接触 Android，并希望直接编写代码，请从构建首个应用教程开始。\n" +
//                        "\n" +
//                        "此外，请通过查看下面的其他资源来学习 Android 开发：\n" +
//                        "\n" +
//                        "Codelab：供您在线自学的短教程，每个教程介绍一个独立主题。大多数 Codelab 会逐步引导您构建小型应用，或向现有应用添加新功能。\n" +
//                        "课程：引导式培训途径，指导您如何构建 Android 应用。\n" +
//                        "在线培训：如果您更喜欢通过视频在线学习，请查看 Udacity 上提供的使用 Kotlin 开发 Android 应用课程（此处嵌有预告片）及下方的其他在线课程。\n" +
//                        "或者，您也可学习以下一小部分基础开发者指南。"))
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,R.drawable.ez)))
                .setContentIntent(pi)

                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(
                    true
                )
                .build()
            manager.notify(1, notification)
        }
    }
}