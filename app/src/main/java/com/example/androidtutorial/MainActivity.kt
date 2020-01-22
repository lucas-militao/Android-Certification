package com.example.androidtutorial

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "1"
    private var builder : Notification.Builder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    @SuppressLint("WrongConstant")
    private fun setupView() {

        showNotificationButton.setOnClickListener(showNotification())
    }

    @SuppressLint("WrongConstant")
    @TargetApi(Build.VERSION_CODES.O)
    private fun showNotification() = View.OnClickListener {

        var notificationId = 123

        var intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }

        var pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        var notification = Notification.Builder(this)
            .setSmallIcon(R.drawable.ic_android)
            .setContentTitle("Minha notificacao")
            .setContentText("Uma nova notificacao")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        var notifyMgr : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notifyMgr.notify(notificationId, notification.build())
    }
}
