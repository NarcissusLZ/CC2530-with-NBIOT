package com.example.smartanimal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChooseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        val choose_object_buton : Button = findViewById(R.id.choose_object_button)
        choose_object_buton.setOnClickListener {
            val intent = Intent(this,ObjectActivity::class.java)
            startActivity(intent)
        }
        val choose_data_buton : Button = findViewById(R.id.choose_data_button)
        choose_data_buton.setOnClickListener {
            val intent = Intent(this,DataActivity::class.java)
            startActivity(intent)
        }

    }
}