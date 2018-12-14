package com.developer.joe.cryptoshift.views

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.developer.joe.cryptoshift.CryptoCoin
import com.developer.joe.cryptoshift.NetworkService
import com.developer.joe.cryptoshift.R
import com.developer.joe.cryptoshift.apiaccess.Endpoint
import com.developer.joe.cryptoshift.apiaccess.service.ApiService
import com.developer.joe.cryptoshift.apiaccess.service.GetMessage
import com.developer.joe.cryptoshift.dbaccess.service.DbAccess
import com.developer.joe.cryptoshift.dbaccess.service.DeleteCryptoValues
import com.developer.joe.cryptoshift.dbaccess.service.InsertCryptoValues
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

/**
 * Implement a screen splash with database update and api access
 *
 * @author Joemerson Souza
 */
class Splash : Activity() {

    lateinit var splashInfo: TextView

    /**
     *
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashInfo = findViewById(R.id.splash_info)
        startAnimation()
        Thread.sleep(1000)
        verifyNetworkConnection()
        DoAsync(this, splashInfo).execute()
    }

    /**
     * Verify connection with internet
     *
     */
    private fun verifyNetworkConnection() {
        if (NetworkService().isConnected(this)) {
            AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("I need internet to work please")
                .setNeutralButton("Nice") { dialogInterface, i ->
                    finish()
                }
                .show()

        }
    }

    /**
     * Splash animation with Glide
     *
     */
    private fun startAnimation() {
        val splashShow : ImageView = findViewById(R.id.splash)
        Glide
            .with(this)
            .load(R.drawable.graph)
            .into(splashShow)
    }

    /**
     * Async work with database charge and api access
     *
     */
    class DoAsync(context: Context, splashInfo: TextView) : AsyncTask<Void, String, Boolean>() {

        private val mapper = jacksonObjectMapper()
        private val mContext = context
        private val mSplashInfo = splashInfo

        override fun onPreExecute() {
            onProgressUpdate("Hey, nice to see you...")
            Thread.sleep(500)
        }

        override fun doInBackground(vararg p0: Void?): Boolean {
            publishProgress("Mining for money...")
            val cryptoCoins = getCryptCoins()
            if(cryptoCoins.isEmpty())
                return false

            publishProgress("Nice, I found some coins...")
            Thread.sleep(500)
            initializeRepository(cryptoCoins)

            return true
        }

        override fun onProgressUpdate(vararg values: String) {
            mSplashInfo.text = values[0]
        }

        override fun onPostExecute(result: Boolean?) {
            mContext.startActivity(Intent(mContext, CryptoView::class.java))
        }

        /**
         * Access repository to insert the crypto coins values
         *
         * @param cryptoCoins Crypto coins
         */
        private fun initializeRepository(cryptoCoins : List<CryptoCoin>) {
            val insertCryptoValues: InsertCryptoValues = DbAccess(mContext)
            val deleteCryptoValues: DeleteCryptoValues = DbAccess(mContext)
            val builder = StringBuilder()
            builder.append("Charging.")
            deleteCryptoValues.deleteAll()
            for (cryptoCoin in cryptoCoins) {
                builder.append(".")
                publishProgress(builder.toString())
                Thread.sleep(20)
                insertCryptoValues.insert(cryptoCoin)
            }
        }

        /**
         * Api access to get all able crypto coins with prices
         *
         */
        private fun getCryptCoins() : List<CryptoCoin> {
            val getMessage: GetMessage = ApiService()
            val jsonCryptoCoins = getMessage.get(Endpoint.PRICE, null)
            return mapper.readValue(jsonCryptoCoins.toString())
        }

    }

}
