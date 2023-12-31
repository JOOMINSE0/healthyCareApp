package com.example.healthycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    lateinit var nextButton: Button
    lateinit var userData: UserDatabase

    //임시) 사용자 이름, 증상 표시될 텍스트뷰
    lateinit var nameTextView: TextView
    lateinit var symptomTextView: TextView
    lateinit var symptomProbTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        nameTextView = findViewById(R.id.text_userName) // 레이아웃의 name 텍스트 뷰 연결
        symptomTextView = findViewById(R.id.text_userSymp) // 레이아웃의 symptom 텍스트 뷰 연결
        symptomProbTextView = findViewById(R.id.text_userSympProb) // 레이아웃의 symptom prob 텍스트 뷰 연결

        //선언re
        nextButton = findViewById<Button>(R.id.nextButton)

        //동작
        nextButton.setOnClickListener {
            var intent = Intent(this, Search::class.java)
            startActivity(intent)
        }
        val secondIntent = intent
        nameTextView.text = secondIntent.getStringExtra("user_name")
        symptomTextView.text = secondIntent.getStringExtra("res_symptom")
        symptomProbTextView.text = secondIntent.getStringExtra("prob")

        // 데이터베이스 호출
        userData = UserDatabase(this, "UserTable", null, 1)

        // 사용자 이름(uName), 사용자 증상(uSymp) 호출
        val cursor = userData.getData()
        if (cursor != null && cursor.moveToFirst()) {
            val nameIndex = cursor.getColumnIndex(UserDatabase.COLUMN_NAME)
            val symptomIndex = cursor.getColumnIndex(UserDatabase.COLUMN_SYMP)

            val nameValue = cursor.getString(nameIndex)
            val symptomValue = cursor.getString(symptomIndex)

            nameTextView.text = nameValue
            symptomTextView.text = symptomValue

            cursor.close()
        }
    }
}