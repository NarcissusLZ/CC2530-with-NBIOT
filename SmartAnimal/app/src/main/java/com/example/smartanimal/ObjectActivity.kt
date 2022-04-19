package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)

        val object_temp_button : Button = findViewById(R.id.object_temp_button)
        object_temp_button.setOnClickListener {
            val intent = Intent(this,TempActivity::class.java)
            startActivity(intent)
        }

        val object_humidity_buton : Button = findViewById(R.id.object_humidity_button)
        object_humidity_buton.setOnClickListener {
            val intent = Intent(this,HumidityActivity::class.java)
            startActivity(intent)
        }

        val object_relay_buton : Button = findViewById(R.id.object_realy_button)
        object_relay_buton.setOnClickListener {
            val intent = Intent(this,RelayActivity::class.java)
            startActivity(intent)
        }

        val object_air_buton : Button = findViewById(R.id.object_air_button)
        object_air_buton.setOnClickListener {
            val intent = Intent(this,AirActivity::class.java)
            startActivity(intent)
        }

        val object_back_buton : Button = findViewById(R.id.object_back_button)
        object_back_buton.setOnClickListener {
            val intent = Intent(this,ChooseActivity::class.java)
            startActivity(intent)
        }
    }
}