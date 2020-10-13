package com.ggramadhan.demonotification


import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = NotificationManagerCompat.from(this)
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        btnSend1.setOnClickListener{
            val name : String = etTitle.text.toString()
            val message : String = etMessage.text.toString()
            val builder =  NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            val notification: Notification = builder.build()
            notificationManager.notify(1, notification)
        }
        btnSend2.setOnClickListener{
            val name : String = etTitle.text.toString()
            val message : String = etMessage.text.toString()
            val builder =  NotificationCompat.Builder(this, BaseApplication.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_favorite)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationManager.IMPORTANCE_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            val notification: Notification = builder.build()
            notificationManager.notify(2, notification)
        }
    }
}