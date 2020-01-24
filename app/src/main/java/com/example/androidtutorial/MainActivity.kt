package com.example.androidtutorial

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_main.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

class MainActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {

    private lateinit var scannerView: ZXingScannerView
    val MY_PERMISSIONS_REQUEST_ACCESS_CAMERA = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scannerView = findViewById(R.id.zxingScanner)

        setupView()
    }

    public fun setupView() {
        requestCameraPermission()
    }

    private fun requestCameraPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "You must give the permission", Toast.LENGTH_SHORT).show()
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    MY_PERMISSIONS_REQUEST_ACCESS_CAMERA)

                scannerView.setResultHandler(this)
                scannerView.startCamera()

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            scannerView.setResultHandler(this)
            scannerView.startCamera()
        }
    }

    override fun onDestroy() {
        scannerView.stopCamera()
        super.onDestroy()
    }

    override fun handleResult(p0: Result?) {
        resultText.text = p0?.text
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }
}
