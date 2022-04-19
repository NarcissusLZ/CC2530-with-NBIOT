package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air)

        val air_back_buton : Button = findViewById(R.id.air_back_button)
        air_back_buton.setOnClickListener {
            val intent = Intent(this,ObjectActivity::class.java)
            startActivity(intent)
        }
    }
}