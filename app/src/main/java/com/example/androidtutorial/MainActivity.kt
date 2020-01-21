package com.example.androidtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var toast : Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        toastTopButton.setOnClickListener(notificationOnTop())
        toastBottomButton.setOnClickListener(notificationOnBottom())
    }

    private fun notificationOnTop() = View.OnClickListener() {
        toast?.cancel()
        toast = null
        toast = Toast.makeText(this, getString(R.string.notification_top), Toast.LENGTH_LONG)
        (toast as Toast).setGravity(Gravity.TOP, 0 , 0)
        (toast as Toast).show()
    }

    private fun notificationOnBottom() = View.OnClickListener() {
        toast?.cancel()
        toast = null
        toast = Toast.makeText(this, getString(R.string.notification_bottom), Toast.LENGTH_LONG)
        (toast as Toast).show()
    }
}
