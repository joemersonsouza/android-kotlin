package com.developer.joe.cryptoshift.DBAccess

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbConnection(
    context: Context?, name: String?="cryptocoins", factory: SQLiteDatabase.CursorFactory?=null, version: Int=1
) :  SQLiteOpenHelper(context, name, factory, version) {

    val CREATE_CRYPTO_TABLE = "CREATE TABLE CRYPTOCOINS (SYMBOL VARCHAR(150), PRICE VARCHAR(100));"
    val DROP_CRYPTO_TABLE = "DROP TABLE CRYPTOCOINS;"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_CRYPTO_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, fromVersion: Int, toVersion: Int) {
        db?.execSQL(DROP_CRYPTO_TABLE)
        db?.execSQL(CREATE_CRYPTO_TABLE)
    }

    fun initializeDB() {
        val db = this.writableDatabase
        onUpgrade(db, 0, 0)
    }
}