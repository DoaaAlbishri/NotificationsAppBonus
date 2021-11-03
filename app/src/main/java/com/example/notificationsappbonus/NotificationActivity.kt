package com.example.notificationsappbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class NotificationActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        imageView=findViewById(R.id.imageView2)
       // imageView.setImageResource(R.mipmap.ic_launcher_egg)
    }
}