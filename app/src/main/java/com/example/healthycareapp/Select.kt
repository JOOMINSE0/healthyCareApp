package com.example.healthycareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.ContentValues

class Select : AppCompatActivity() {
    lateinit var nextButton: Button
    lateinit var button1:Button
    lateinit var button2:Button
    lateinit var button3:Button
    lateinit var button4:Button
    lateinit var button5:Button
    lateinit var button6:Button
    lateinit var button7:Button
    lateinit var button8:Button
    lateinit var userData: UserDatabase
//    lateinit val total_symptom=0
//    lateinit val covid19_symptom=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        //선언
        nextButton = findViewById<Button>(R.id.nextButton)
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)
        button5 = findViewById<Button>(R.id.button5)
        button6 = findViewById<Button>(R.id.button6)
        button7 = findViewById<Button>(R.id.button7)
        button8 = findViewById<Button>(R.id.button8)
        var total_symptom = 0
        var covid19_symptom = 0
        var res_symptom = "None"
        var name = "건강하조 "
        var prob = -1
        //동작
        nextButton.setOnClickListener{
            if (covid19_symptom!=0){
                res_symptom = "코로나"
                var for_calc=covid19_symptom.toDouble()
                //prob = (covid19_symptom/total_symptom)*100
                prob = ((for_calc/total_symptom)*100).toInt()
                print(prob)
            }
            else{
                res_symptom = "감기"
                prob = 80
            }
           /* //코로나or감기 결과 정해지면 DB의 uSymp에 결과값 insert
            val dbHelper = DBHelper(this)
            userData=UserDatabase(this, "UserTable", null, 1)

            val values = ContentValues()
            values.put(DBHelper.COLUMN_SYMP, res_symptom)//result.text.toString()) //result=코로나or감기 결과 변수(임의)

            val db = dbHelper.writableDatabase
            db.insert(dbHelper.TABLE_NAME, null, values)
*/
            var intent = Intent(this, Result::class.java)
            intent.putExtra("user_name", name)
            intent.putExtra("res_symptom", res_symptom)
            intent.putExtra("prob", prob.toString())
            startActivity(intent)
        }
        button1.setOnClickListener{
            button1.text = "selected"
            total_symptom++
            covid19_symptom++
        }
        button2.setOnClickListener{
            button2.text = "selected"
            total_symptom++
        }
        button3.setOnClickListener{
            button3.text = "selected"
            total_symptom++
            covid19_symptom++
        }
        button4.setOnClickListener{
            button4.text = "selected"
            total_symptom++
        }
        button5.setOnClickListener{
            button5.text = "selected"
            total_symptom++
        }
        button6.setOnClickListener{
            button6.text = "selected"
            total_symptom++
        }
        button7.setOnClickListener{
            button7.text = "selected"
            total_symptom++
            covid19_symptom++
        }
        button8.setOnClickListener{
            button8.text = "selected"
            total_symptom++
        }
    }
}