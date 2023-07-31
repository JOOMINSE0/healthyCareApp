package com.example.healthycareapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.maps.GoogleMap

class Search : AppCompatActivity() {
    private lateinit var mapView: GoogleMap
    lateinit var homeButton: Button
    lateinit var beforeButton: Button
    lateinit var userData: UserDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        //지도 연결
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        val mapsFragment = MapsFragment(this)
        fragmentTransaction.add(R.id.map, mapsFragment)
        fragmentTransaction.commit()

        //데이터베이스 호출
        val DBHelper = DBHelper(this)
        userData=UserDatabase(this, "UserDatabase", null, 1)

        //선언(home)
        homeButton = findViewById<Button>(R.id.homeButton)

        //동작
        homeButton.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        //선언(before)
        beforeButton = findViewById<Button>(R.id.beforeButton)

        //동작
        beforeButton.setOnClickListener{
            var intent = Intent(this, Result::class.java)
            startActivity(intent)
        }




        //코로나or감기 결과 정해지면 DB의 uSymp에 결과값 insert
        /*val values = ContentValues()
        values.put(DBHelper.COLUMN_SYMP, result.text.toString()) //result=코로나or감기 결과 변수(임의)

        val db = DBHelper.writableDatabase
        db.insert(DBHelper.TABLE_NAME, null, values)*/


    }
}