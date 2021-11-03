package com.example.notificationsappbonus

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val channelId = "myapp.notifications"
    private val description = "Notification App Example"
    private val notificationId = 1234
    lateinit var builder: Notification.Builder
    lateinit var showbtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showbtn = findViewById(R.id.showbtn)
        showbtn.setOnClickListener {
                val notificationManager =
                        getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                val intent = Intent(this, NotificationActivity::class.java)
                val pendingIntent =
                        PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    var notificationChannel = NotificationChannel(
                            channelId,
                            description,
                            NotificationManager.IMPORTANCE_HIGH
                    )
                    notificationManager.createNotificationChannel(notificationChannel)
                    builder = Notification.Builder(this, channelId)
                            .setSmallIcon(R.drawable.ic_notification)
                            .setLargeIcon(
                                    BitmapFactory.decodeResource(
                                            this.resources,
                                            R.drawable.ic_notification
                                    )
                            )
                            .setContentIntent(pendingIntent)
                            .setContentTitle("Egg Cooking Timer")
                            .setContentText("Ready")
                } else {
                    builder = Notification.Builder(this)
                            .setSmallIcon(R.drawable.ic_notification)
                            .setLargeIcon(
                                    BitmapFactory.decodeResource(
                                            this.resources,
                                            R.drawable.ic_notification
                                    )
                            )
                            .setContentIntent(pendingIntent)
                            .setContentTitle("Egg Cooking Timer")
                            .setContentText("Ready")
                }
            val countDownTimer = object : CountDownTimer(5000,1000) {
                override fun onTick(p0: Long) {
                }
                override fun onFinish() {
                    notificationManager.notify(notificationId, builder.build())
                }
            }
            countDownTimer.start()
            }
        }
    }