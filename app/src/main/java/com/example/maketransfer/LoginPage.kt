package com.example.maketransfer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginPage : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login_page)

        val txtRegister = findViewById<TextView>(R.id.txtRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
            finish()

        }

    }
}