package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login_buton : Button = findViewById(R.id.login_button)
        login_buton.setOnClickListener {
            val intent1 = Intent(this,ChooseActivity::class.java)
            startActivity(intent1)
        }

    }
}