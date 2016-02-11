package com.developer.joe.cryptoshift.dbaccess.service

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.developer.joe.cryptoshift.CryptoCoin
import com.developer.joe.cryptoshift.dbaccess.repository.SqlLiteAccess

class DbAccess(context: Context) : InsertCryptoValues, GetCryptoValues, DeleteCryptoValues {

    private val mContext = context
    private val tableName = "CRYPTOCOINS"
    private val columnSymbol = "SYMBOL"
    private val columnPrice = "PRICE"

    override fun deleteAll() {
        val dbAccess = SqlLiteAccess(mContext)
        val dbWriter = dbAccess.writableDatabase
        dbWriter.delete(tableName,null,null)
    }

    /**
     * Insert crypto coins on database
     *
     * @param cryptoCoin Crypto coin object
     */
    override fun insert(cryptoCoin: CryptoCoin) {
        val dbAccess = SqlLiteAccess(mContext)
        val content = toContentValues(cryptoCoin)

        val dbWriter = dbAccess.writableDatabase
        dbWriter.insert(tableName, null, content)
        dbWriter.close()
    }

    /**
     * Insert a CryptoCoin into a repository
     *
     * @return cryptoCoin Crypto coin object
     */
    override fun get(): ArrayList<CryptoCoin> {
        val dbAccess = SqlLiteAccess(mContext)
        val dbReader = dbAccess.readableDatabase
        val cryptoCoins = ArrayList<CryptoCoin>()
        val columns = arrayOf(columnSymbol,columnPrice)
        val cursor = dbReader.query(tableName,
                                            columns,
                                            null,
                                            null,
                                            null,
                                            null,
                                            null)

        if(cursor != null && cursor.moveToFirst()) {
            cryptoCoins.add(
                CryptoCoin(symbol = cursor.getString(cursor.getColumnIndex(columnSymbol)), price = cursor.getString(cursor.getColumnIndex(columnPrice)))
            )
            while (cursor.moveToNext()) {
                cryptoCoins.add(
                    CryptoCoin(symbol = cursor.getString(cursor.getColumnIndex(columnSymbol)), price = cursor.getString(cursor.getColumnIndex(columnPrice)))
                )
            }
            cursor.close()
        }

        return cryptoCoins
    }


    /**
     * Mapper from CryptoCoin to ContentValues
     *
     * @param cryptoCoin Crypto coin object
     * @return a content value object
     */
    private fun toContentValues(cryptoCoin: CryptoCoin) : ContentValues {

        val content = ContentValues()
        content.put(columnSymbol, cryptoCoin.symbol)
        content.put(columnPrice, cryptoCoin.price)

        return content
    }
}