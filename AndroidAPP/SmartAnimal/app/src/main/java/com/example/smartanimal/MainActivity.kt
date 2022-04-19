package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start_sign_in_buton : Button = findViewById(R.id.start_sign_in_button)
        start_sign_in_buton.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        val start_sign_up_buton : Button = findViewById(R.id.start_sign_up_button)
        start_sign_up_buton.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        val start_help_buton : Button = findViewById(R.id.start_help_button)
        start_help_buton.setOnClickListener {
            val intent = Intent(this,HelpActivity::class.java)
            startActivity(intent)
        }
    }

}