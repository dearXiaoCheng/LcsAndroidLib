package com.lcs.quickDevelop

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lcs.arch.permission.requestPermission

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION)

    }
}