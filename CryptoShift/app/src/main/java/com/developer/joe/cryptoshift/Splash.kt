package com.developer.joe.cryptoshift

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.developer.joe.cryptoshift.apiaccess.Endpoint
import com.developer.joe.cryptoshift.apiaccess.service.ApiService
import com.developer.joe.cryptoshift.apiaccess.service.GetMessage
import com.developer.joe.cryptoshift.dbaccess.repository.SqlLiteAccess
import com.developer.joe.cryptoshift.dbaccess.service.DbAccess
import com.developer.joe.cryptoshift.dbaccess.service.InsertCryptoValues
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class Splash : Activity() {

    private val mapper = jacksonObjectMapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startAnimation()
        createDatabase()
        initializeRepository()
        //TODO: Open new activity
    }

    private fun initializeRepository() {
        val cryptoCoins = getCryptCoins()

        val insertCryptoValues: InsertCryptoValues = DbAccess(this)
        for (cryptoCoin in cryptoCoins) {
            insertCryptoValues.insert(cryptoCoin)
        }
    }

    private fun getCryptCoins() : List<CryptoCoin> {
        val getMessage: GetMessage = ApiService()
        val jsonCryptoCoins = getMessage.get(Endpoint.PRICE, null)
        return mapper.readValue(jsonCryptoCoins.toString())
    }

    private fun createDatabase() {
        val dbConnection = SqlLiteAccess(this)
        dbConnection.initializeDB()
    }

    private fun startAnimation() {
        val splashShow = findViewById(R.id.splash) as ImageView
        Glide
            .with(this)
            .load(R.drawable.graph)
            .into(splashShow)
    }
}
