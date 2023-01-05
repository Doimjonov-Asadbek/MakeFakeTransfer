package com.example.maketransfer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register_page)

        val txtLogin = findViewById<TextView>(R.id.txtLogin)

        txtLogin.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }

    }
}