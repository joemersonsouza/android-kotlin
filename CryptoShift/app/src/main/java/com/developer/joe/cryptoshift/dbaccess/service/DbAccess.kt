package com.developer.joe.cryptoshift.dbaccess.service

import android.content.ContentValues
import android.content.Context
import com.developer.joe.cryptoshift.CryptoCoin
import com.developer.joe.cryptoshift.dbaccess.repository.SqlLiteAccess

class DbAccess(context: Context) : InsertCryptoValues {

    private val mContext = context

    /**
     * Insert crypto coins on database
     *
     * @param cryptoCoin Crypto coin object
     */
    override fun insert(cryptoCoin: CryptoCoin) {
        val dbAccess = SqlLiteAccess(mContext)
        val content = toContentValues(cryptoCoin)

        val dbWriter = dbAccess.writableDatabase
        dbWriter.insert("CRYPTOCOIN", null, content)
        dbWriter.close()
    }

    /**
     * Mapper from CryptoCoin to ContentValues
     *
     * @param cryptoCoin Crypto coin object
     * @return a content value object
     */
    private fun toContentValues(cryptoCoin: CryptoCoin) : ContentValues {

        val content = ContentValues()
        content.put("SYMBOL", cryptoCoin.symbol)
        content.put("PRICE", cryptoCoin.price)

        return content
    }
}