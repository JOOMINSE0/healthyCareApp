package com.example.healthycareapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle


class UserDatabase(context: Context, name:String?, factory: SQLiteDatabase.CursorFactory?, version:Int)
    : SQLiteOpenHelper(context, name, factory, version){

    companion object {
        const val TABLE_NAME = "UserTable"
        const val COLUMN_NAME = "uName"
        const val COLUMN_DONG = "uDong"
        const val COLUMN_SYMP = "uSymp"
        const val COLUMN_ADDRESS = "uAddress"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // 데이터베이스 테이블 생성
        db!!.execSQL("CREATE TABLE UserTable( uName CHAR(10), uDong CHAR(5), uSymp CHAR(3), uAddress CHAR(30));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    // 사용자 정보를 가져오는 함수
    fun getData(): Cursor? {
        val db = readableDatabase
        return db.query("UserTable", arrayOf("uName", "uSymp", "uAddress"), null, null, null, null, null)
    }

    fun insertData(name: String, dong: String, symp: String, address: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_DONG, dong)
            put(COLUMN_SYMP, symp)
            put(COLUMN_ADDRESS, address)
        }
        return db.insert(TABLE_NAME, null, values)
}

    fun saveResult(uName: String, uSymp: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_SYMP, uSymp)
        db.update(TABLE_NAME, values, "$COLUMN_NAME=?", arrayOf(uName))
    }

}