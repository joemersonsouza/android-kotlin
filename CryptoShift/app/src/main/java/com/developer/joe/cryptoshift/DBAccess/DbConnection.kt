package com.developer.joe.cryptoshift.DBAccess

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
* Database connection access
* 
* @author Joemerson Souza
**/
class DbConnection(
    context: Context?, name: String?="cryptocoins", factory: SQLiteDatabase.CursorFactory?=null, version: Int=0
) :  SQLiteOpenHelper(context, name, factory, version) {

    /**
    * Method called when database is created
    *
    * @param db Instance of database
    **/
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbAction.CREATE_CRYPTO_TABLE)
    }

    /**
    * Method called when database is updated
    *
    * @param db Instance of database
    * @param fromVersion current version
    * @param toVersion next version
    **/
    override fun onUpgrade(db: SQLiteDatabase?, fromVersion: Int, toVersion: Int) {
        db?.execSQL(DbAction.DROP_CRYPTO_TABLE)
        db?.execSQL(DbAction.CREATE_CRYPTO_TABLE)
    }
    
    /**
    * Initialize Database Constructor
    *
    **/
    fun initializeDB() {
        val db = this.writableDatabase
        onUpgrade(db, 0, 0)
    }
}
