package com.gezioteam.gezio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val btn1 = findViewById<Button>(R.id.button)
        btn1.setOnClickListener{
            Toast.makeText(this,"Coming Soon...", Toast.LENGTH_SHORT).show()
        }
        val btn2 = findViewById<Button>(R.id.button2)
        btn2.setOnClickListener{
            Toast.makeText(this,"Coming Soon...", Toast.LENGTH_SHORT).show()
        }
        val btn3 = findViewById<Button>(R.id.button3)
        btn3.setOnClickListener{
            Toast.makeText(this,"Coming Soon...", Toast.LENGTH_SHORT).show()
        }
        val btn4 = findViewById<Button>(R.id.button4)
        btn4.setOnClickListener{
            Toast.makeText(this,"Coming Soon...", Toast.LENGTH_SHORT).show()
        }
        val back = findViewById<AppCompatButton>(R.id.backtomainmenu)
        back.setOnClickListener{
            backMainpage()
        }


    }
    fun backMainpage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}