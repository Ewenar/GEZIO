package com.gezioteam.gezio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gezioteam.gezio.databinding.ActivitySignUpBinding
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonSignup = findViewById<Button>(R.id.signUpButton)
        buttonSignup.setOnClickListener {
            signup()
        }

        binding.login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signup() {
        // Retrieve input values
        val realName = findViewById<EditText>(R.id.name).text.toString()
        val nickname = findViewById<EditText>(R.id.nickname).text.toString()
        val email = findViewById<EditText>(R.id.email).text.toString()
        val dateOfBirth = findViewById<EditText>(R.id.dateOfBirth).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()
        val repassword = findViewById<EditText>(R.id.rePassword).text.toString()

        // Validate inputs (you might want to add more sophisticated validation)
        if (realName.isBlank() || nickname.isBlank() || email.isBlank() || dateOfBirth.isBlank() || password.isBlank() || repassword.isBlank()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != repassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
        navigateToLoginActivity()

    }

    private fun navigateToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}
