package com.example.healthycareapp

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
    lateinit var name: EditText
    lateinit var dong: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personnel_info)

        name=findViewById(R.id.nameEditText)
        dong=findViewById(R.id.locateEditText)

        userData=UserDatabase(this, "UserDatabase", null, 1)

        //선언
        nextButton = findViewById<Button>(R.id.nextButton)

        //동작
        nextButton.setOnClickListener{
            //사용자의 이름과 지역(동) 정보가 DB에 저장
            sqlitedb=userData.writableDatabase
            sqlitedb.execSQL("INSERT INTO UserDatabase VALUES('"+name+"' + '"+dong+"');")
            sqlitedb.close()

            var intent = Intent(this, Select::class.java)
            startActivity(intent)
        }
    }
}