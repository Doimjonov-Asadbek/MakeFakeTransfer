package com.example.maketransfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
                val intent = Intent(this, LoginPage::class.java)
                startActivity(intent)
                finish()
        }, 500)
    }
}