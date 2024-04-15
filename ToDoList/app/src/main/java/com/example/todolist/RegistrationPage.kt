package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val sign_in: TextView = findViewById(R.id.sign_in_txt)
    val register:TextView = findViewById(R.id.Register_txt)
        register.setOnClickListener {
            Toast.makeText(this@RegistrationPage , "Register clicked",
                Toast.LENGTH_LONG).show()
        }
        sign_in.setOnClickListener {
            val intent = Intent(this , sign_in::class.java)
            startActivity(intent)
        }
    }
}