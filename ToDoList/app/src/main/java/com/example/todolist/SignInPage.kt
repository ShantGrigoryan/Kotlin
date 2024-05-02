
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.R
import com.example.todolist.RegistrationPage

class SignInPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in_page)

        val emailEditText: EditText = findViewById(R.id.Email)
        val passwordEditText: EditText = findViewById(R.id.Password)
        val loginButton: TextView = findViewById(R.id.Login_txt)
        val signUpText: TextView = findViewById(R.id.sign_in_txt)

//        loginButton.setOnClickListener {
//            val email = emailEditText.text.toString().trim()
//            val password = passwordEditText.text.toString().trim()
//
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                val credentials = DataModel(email, email, password)
//
//                GlobalScope.launch(Dispatchers.Main) {
//                    try {
//                        val response = ApiService.RetrofitClient.service.login(credentials)
//
////                        val response =
//                        if (response.isSuccessful) {
//                            val token = response.body()?.token
////                             Save token to shared preferences or perform other actions
//                            Toast.makeText(
//                                this@SignInPage,
//                                "Login successful. Token: $token",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        } else {
//                            // Handle login failure
//                            Toast.makeText(
//                                this@SignInPage,
//                                "Login failed. Please check your credentials.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    } catch (e: Exception) {
//                        // Handle network or server errors
//                        Toast.makeText(
//                            this@SignInPage,
//                            "An error occurred. Please try again later.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            } else {
//                // Show error message if email or password is empty
//                Toast.makeText(
//                    this@SignInPage,
//                    "Please enter both email and password.",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }

        signUpText.setOnClickListener {
            val intent = Intent(this, RegistrationPage::class.java)
            startActivity(intent)
        }
    }
}
