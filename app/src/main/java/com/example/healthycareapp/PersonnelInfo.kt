package com.example.healthycareapp

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PersonnelInfo : AppCompatActivity() {
    lateinit var nextButton: Button
    lateinit var userData: UserDatabase
    lateinit var sqlitedb: SQLiteDatabase
    lateinit var userName: EditText
    lateinit var userDong: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_info)

        userName=findViewById(R.id.nameEditText)
        userDong=findViewById(R.id.locateEditText)

        val dbHelper = DBHelper(this)

        userData=UserDatabase(this, "UserDatabase", null, 1)

        //선언
        nextButton = findViewById<Button>(R.id.nextButton)

        //동작
        nextButton.setOnClickListener{
            //사용자의 이름과 지역(동) 정보가 DB에 저장

            // 데이터 추가
            val values = ContentValues()
            values.put(DBHelper.COLUMN_NAME, userName.text.toString())
            values.put(DBHelper.COLUMN_DONG, userDong.text.toString())

            // 데이터베이스에 데이터 추가
            val db = dbHelper.writableDatabase
            db.insert(dbHelper.TABLE_NAME, null, values)

            var intent = Intent(this, Select::class.java)
            startActivity(intent)
        }

    }
}