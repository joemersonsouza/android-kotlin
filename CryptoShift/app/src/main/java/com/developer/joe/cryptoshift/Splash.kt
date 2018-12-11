package com.developer.joe.cryptoshift

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.developer.joe.cryptoshift.APIAccess.adapter.ApiAdapterImpl
import com.developer.joe.cryptoshift.DBAccess.DbConnection
import org.json.JSONArray

class Splash : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startAnimation()
        createDatabase()
        val apiAdapter = ApiAdapterImpl()
        JSONArray coinsPrices = ApiAdapter
        //TODO: Recriate database
        //TODO: Open the new table
    }

    private fun createDatabase() {
        val dbConnection = DbConnection(this)
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
