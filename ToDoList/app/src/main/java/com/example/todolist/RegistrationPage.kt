package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
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
        val register: TextView = findViewById(R.id.Register_txt)
        val Name : EditText = findViewById(R.id.Fullname)
        val Email: EditText = findViewById(R.id.Email)
        val Password: EditText = findViewById(R.id.Password)
        val Confirm_password: EditText = findViewById(R.id.Confirm_Password)
                register.setOnClickListener {
//            Toast.makeText(this@RegistrationPage , "Register clicked",
//                Toast.LENGTH_LONG).show()
//                    if(Password.text.toString() == Confirm_password.text.toString()){
                        val db = DBHelper(this, null)
                        val name = Name.text.toString()
                        val email = Email.text.toString()
                        val password = Password.text.toString()

                        db.addUser(name , email , password)
                        val intent = Intent(this , UserPage::class.java)
                        startActivity(intent)
//                    }

        }
        sign_in.setOnClickListener {
            val intent = Intent(this, SignInPage::class.java)
            startActivity(intent)
        }
    }
}