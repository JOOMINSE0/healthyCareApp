package com.example.healthycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //선언
        startButton = findViewById<Button>(R.id.startButton)

        //동작
        startButton.setOnClickListener{
            var intent = Intent(this, PersonnelInfo::class.java)
            startActivity(intent)
        }
    }
}