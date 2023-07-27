package com.example.healthycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PersonnelInfo : AppCompatActivity() {
    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_info)

        //선언
        nextButton = findViewById<Button>(R.id.nextButton)

        //동작
        nextButton.setOnClickListener{
            var intent = Intent(this, Select::class.java)
            startActivity(intent)
        }
    }
}