package com.developer.joe.cryptoshift.views

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.developer.joe.cryptoshift.CryptoCoin
import com.developer.joe.cryptoshift.R
import com.developer.joe.cryptoshift.dbaccess.service.DbAccess
import com.developer.joe.cryptoshift.dbaccess.service.GetCryptoValues

class CryptoView : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_view)
        val coinsView = findViewById<ListView>(R.id.listCoins)
        val cryptoCoins = getCryptoCoins()
        checkListOfCoins(cryptoCoins)
        val adapter = ArrayAdapter<CryptoCoin>(this, android.R.layout.simple_list_item_1, cryptoCoins)
        coinsView.adapter = adapter
    }

    private fun getCryptoCoins() : ArrayList<CryptoCoin> {
        val getCryptoValues : GetCryptoValues = DbAccess(this)
        return getCryptoValues.get()
    }

    /**
     * Verify connection with internet
     *
     */
    private fun <T> checkListOfCoins(cryptoCoins: List<T>) {
        if (cryptoCoins.isEmpty()) {
            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Any coins was found")
                .setNeutralButton("Ok") { dialogInterface, i ->

                }
                .show()

        }
    }

}
