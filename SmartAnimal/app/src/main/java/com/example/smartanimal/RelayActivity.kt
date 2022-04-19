package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RelayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relay)

        val relay_back_buton : Button = findViewById(R.id.relay_back_button)
        relay_back_buton.setOnClickListener {
            val intent = Intent(this,ObjectActivity::class.java)
            startActivity(intent)
        }
    }
}