package com.example.healthycareapp

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle

class UserDatabase(context: Context, name:String?, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        // 데이터베이스 테이블 생성
        db!!.execSQL("CREATE TABLE UserTable( uName CHAR(10), uDong CHAR(5), uSymp CHAR(3), uAddress CHAR(30));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}

//코로나or감기 증상 결과를 uSymp에 저장하고 Result클래스에서 uSymp호출하여 출력
class DBHelper(context: Context) : SQLiteOpenHelper(context, "UserDatabase", null, 1) {

    companion object {
        const val TABLE_NAME = "UserDatabase"
        const val COLUMN_NAME = "uName"
        const val COLUMN_DONG = "uDong"
        const val COLUMN_SYMP = "uSymp"
        const val COLUMN_ADDRESS = "uAddress"
    }

    val TABLE_NAME= "UserDatabase"
    val COLUMN_NAME= "uName"
    val COLUMN_DONG= "uDong"
    val COLUMN_SYMP= "uSymp"
    val COLUMN_ADDRESS= "uAddress"

    fun getData(): Cursor? {
        val db = readableDatabase
        return db.query("UserDatabase", arrayOf("uName", "uDong", "uSymp", "uAddress"), null, null, null, null, null)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // 이 클래스에서 따로 데이터베이스 테이블을 생성할 필요가 없으므로 생략
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 이 클래스에서 따로 업그레이드 로직이 필요하지 않으므로 생략
    }

}