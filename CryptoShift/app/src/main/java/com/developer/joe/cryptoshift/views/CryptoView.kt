package com.developer.joe.cryptoshift.views

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import com.developer.joe.cryptoshift.CryptoCoin
import com.developer.joe.cryptoshift.R
import com.developer.joe.cryptoshift.dbaccess.service.DbAccess
import com.developer.joe.cryptoshift.dbaccess.service.GetCryptoValues

/**
 * Implement a crypto view activity
 * Responsible to list the coins on the ListView with search bar
 *
 * @author Joemerson Souza
 */
class CryptoView : Activity() {

    /**
     * Default constructor
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_view)
        val coinsView = findViewById<ListView>(R.id.listCoins)
        val cryptoCoins = getCryptoCoins()
        checkListOfCoins(cryptoCoins)
        val adapter = ArrayAdapter<CryptoCoin>(this, android.R.layout.simple_list_item_1, cryptoCoins)
        coinsView.adapter = adapter
        findCryptoCoinByText(this, coinsView)
    }

    /**
     * Find crypto coin based on text
     *
     * @param context context
     * @param coinsView List view with coins
     */
    private fun findCryptoCoinByText(context: Context, coinsView: ListView) {
        val searchView = findViewById<EditText>(R.id.search)
        searchView.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(search: Editable?) {
                if(search?.length!! >= 2) {
                    val getCryptoValues: GetCryptoValues = DbAccess(context)
                    val cryptoCoins = getCryptoValues.get(search.toString().toUpperCase())
                    if(!cryptoCoins.isEmpty()) {
                        val adapter =
                            ArrayAdapter<CryptoCoin>(context, android.R.layout.simple_list_item_1, cryptoCoins)
                        coinsView.adapter = adapter
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    /**
     * Get crypto coins on database
     *
     * @return a list of crypto coins
     */
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
                .setNeutralButton("Ok") { _, _ ->

                }
                .show()

        }
    }

}
