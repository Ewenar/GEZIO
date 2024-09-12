package com.gezioteam.gezio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.gezioteam.gezio.databinding.ActivityLoginBinding
import com.gezioteam.gezio.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var loginButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(View.OnClickListener {
            if (binding.email.text.toString() == "user" && binding.password.text.toString() == "1234") {
                Toast.makeText(this, "Login Succesful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })

            binding.signUp.setOnClickListener {
                val loginintent = Intent(this, SignUpActivity::class.java)
                startActivity(loginintent)
            }
        }
}