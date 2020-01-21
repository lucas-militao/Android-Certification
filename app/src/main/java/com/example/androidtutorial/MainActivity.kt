package com.example.androidtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        var toast = Toast.makeText(this, getString(R.string.notification_top), Toast.LENGTH_LONG)
        toast.setGravity(Gravity.TOP, 0 , 0)
        toast.show()
    }

    private fun notificationOnBottom() = View.OnClickListener() {
        Toast.makeText(this, getString(R.string.notification_bottom), Toast.LENGTH_LONG).show()
    }
}
