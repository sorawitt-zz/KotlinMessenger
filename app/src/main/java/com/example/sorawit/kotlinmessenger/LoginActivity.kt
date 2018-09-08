package com.example.sorawit.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button_login.setOnClickListener {
            Log.d("LoginActivity", "LOGIN!!!")
            val email = email_text_login.text.toString()
            val password = password_text_login.text.toString()

        }

        back_to_reg_text_login.setOnClickListener {
            finish()
        }

    }
}