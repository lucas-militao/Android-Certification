package com.example.androidtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        showNotificationButton.setOnClickListener(showSnackbar())
    }

    private fun showSnackbar() = View.OnClickListener {
        var snackbar = Snackbar.make(principal, "Notificando aqui oh!", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}
