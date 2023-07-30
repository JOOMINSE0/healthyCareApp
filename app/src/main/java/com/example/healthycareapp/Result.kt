package com.example.healthycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Result : AppCompatActivity() {
    lateinit var nextButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //선언re
        nextButton = findViewById<Button>(R.id.nextButton)

        //동작
        nextButton.setOnClickListener{
            var intent = Intent(this, Search::class.java)
            startActivity(intent)
        }
    }
}