package com.christianrruiz.proyecto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(0)
        setTheme(R.style.Theme_Proyecto)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}