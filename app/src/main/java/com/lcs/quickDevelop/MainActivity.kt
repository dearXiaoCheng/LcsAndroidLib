package com.lcs.quickDevelop

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, com.lcs.arch.utils.DeviceUtils.isRoot().toString(), Toast.LENGTH_SHORT)
            .show()
    }
}