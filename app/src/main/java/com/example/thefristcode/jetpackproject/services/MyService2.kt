package com.example.thefristcode.jetpackproject.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.thefristcode.jetpackproject.R
import com.example.thefristcode.jetpackproject.permisssiongs.PermissionActivity
import java.lang.Exception

class MyService2 : Service() {
    override fun onCreate() {
        super.onCreate()
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("my_service", "前台 service", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
        }
        val intent = Intent(this, PermissionActivity::class.java)
        val pi = PendingIntent.getActivity(this, 0, intent, 0)
        val notification = NotificationCompat.Builder(this, "my_service")
            .setContentTitle("this is  forground services  Title")
            .setContentText("this is froeground service Text")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pi)
            .build()

        try {
           startForeground(111,notification)
        }catch (e:Exception){
            e.printStackTrace()
        }

    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
