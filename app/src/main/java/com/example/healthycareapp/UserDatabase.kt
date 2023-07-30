package com.example.healthycareapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabase(context: Context, name:String?, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(db: SQLiteDatabase?) {
        // 데이터베이스 테이블 생성
        db!!.execSQL("CREATE TABLE UserDatabase( uName CHAR(10), uDong CHAR(5), uAddress CHAR(30));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


}