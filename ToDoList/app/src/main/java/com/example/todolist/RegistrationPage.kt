package com.example.todolist


import SignInPage
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.Registration.API.DataModel.DataModel
import com.example.todolist.Registration.API.Register.RetrofitClient

@Suppress("UNREACHABLE_CODE")
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
        val Name: EditText = findViewById(R.id.Fullname)
        val Email: EditText = findViewById(R.id.Email)
        val Password: EditText = findViewById(R.id.Password)
        val Confirm_password: EditText = findViewById(R.id.Confirm_Password)
        register.setOnClickListener {
            val name = Name.text.toString()
            val email = Email.text.toString()
            val password = Password.text.toString()
            val conf_password: String = Confirm_password.text.toString()
//            val users = DataModel(name, email, password)
//            if (password == conf_password) {
//
//                RetrofitClient.service.createUsers(users)
//                .enqueue(object : retrofit2.Callback<DataModel> {
//
//                    override fun onResponse(
//                        call: Call<DataModel>,
//                        response: retrofit2.Response<DataModel>
//                    )
//                    {
//                        if (response.isSuccessful) {
////                            val intent = Intent(this@RegistrationPage, UserPage::class.java)
////                            startActivity(intent)
////                            Toast.makeText(
////                                this@RegistrationPage,
////                                "Login or password invalid",
////                                Toast.LENGTH_LONG
////                            ).show()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<DataModel>, t: Throwable) {
//                        TODO("Not yet implemented")
//
//                    }
//                })
//            }
//            else{
//                Toast.makeText(
//                    this@RegistrationPage,
//                    "Login or password invalid",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }
            val user =
                DataModel(name ,email, password)
            if (password == conf_password) {
                RetrofitClient.service.createUsers(user)
                    .enqueue(object : retrofit2.Callback<DataModel> {
                        override fun onResponse(
                            call: retrofit2.Call<DataModel>,
                            response: retrofit2.Response<DataModel>
                        ) {
                            if (response.isSuccessful) {
                                val intent = Intent(this@RegistrationPage
                                    , UserPage::class.java)
                                startActivity(intent)

                            }
                            else{
                                Toast.makeText(this@RegistrationPage , "${response}" , Toast.LENGTH_LONG).show()

                            }
                        }

                        override fun onFailure(call: retrofit2.Call<DataModel>, t: Throwable) {
                            Toast.makeText(this@RegistrationPage , "$t" , Toast.LENGTH_LONG).show()
                        }
                    })
            }
            else{
                Toast.makeText(this@RegistrationPage , "pass" , Toast.LENGTH_LONG).show()

            }
        }
        sign_in.setOnClickListener {
            val intent = Intent(this, SignInPage::class.java)
            startActivity(intent)

        }
    }
}