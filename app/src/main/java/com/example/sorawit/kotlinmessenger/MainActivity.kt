package com.example.sorawit.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        register_button_register.setOnClickListener {
            preformRegister()
        }

        login_text_register.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun preformRegister() {
        val username = username_text_register.text.toString()
        val email = email_text_register.text.toString()
        val password = password_text_register.text.toString()

        if (email.isEmpty() || password.isEmpty() ) {
            Toast.makeText(this,"Please enter text in email/pw", Toast.LENGTH_SHORT).show()
            return
        }
        Log.d("MainActivity", "username:" + username)
        Log.d("MainActivity", "email:" + email)
        Log.d("MainActivity", "password:" + password)

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Toast.makeText(this,"Register Successful with ${it.result.user.email}", Toast.LENGTH_SHORT).show()
                    Log.d("Mainactivity", "Register successful ${it.result.user.uid}")
                }

                .addOnFailureListener {
                    Toast.makeText(this, "${it.message}", Toast.LENGTH_SHORT).show()
                }
    }
}
