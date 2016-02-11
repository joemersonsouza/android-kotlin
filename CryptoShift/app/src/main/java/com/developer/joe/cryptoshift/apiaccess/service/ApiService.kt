package com.developer.joe.cryptoshift.apiaccess.service

import com.developer.joe.cryptoshift.apiaccess.ApiAddress.BINANCE
import com.developer.joe.cryptoshift.apiaccess.Endpoint
import com.developer.joe.cryptoshift.apiaccess.HttpMethod
import com.developer.joe.cryptoshift.apiaccess.HttpMethod.HTTP_GET
import com.developer.joe.cryptoshift.apiaccess.repository.ApiRepositoryImpl
import com.developer.joe.cryptoshift.apiaccess.repository.GetConnection
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Api service
 *
 * @author Joemerson Souza
 */
class ApiService : GetMessage, SendMessage {

    private val connection: GetConnection = ApiRepositoryImpl()

    /**
     * Get a message from server
     *
     * @param endpoint Endpoint
     * @param params Mapper with key and value
     * @return a json array
     */
    override fun get(endpoint: Endpoint, params: Map<String, String>?): JSONArray {

        checkNotNull(endpoint)

        val url = getUrl(endpoint, params)
        val apiConnection = connection.get(HTTP_GET, url)
        apiConnection?.doOutput = false

        if (apiConnection?.responseCode == HttpsURLConnection.HTTP_OK) {
            return readResponseMessage(apiConnection)
        }

        return JSONArray(JSONObject("{message: 'Sorry, I tried to connect but was not so good'}"))
    }

    /**
     * Get a HTTP URL
     *
     * @param endpoint Endpoint
     * @param params Mapper with key and value
     * @return an URL connection
     */
    private fun getUrl(
        endpoint: Endpoint,
        params: Map<String, String>?
    ): URL {

        val apiFullAddress = "${BINANCE}${endpoint}${getFormattedParams(params)}"
        return URL(apiFullAddress)
    }

    /**
     * Prepare the URL params to RestFull get
     *
     * @param params Mapper with key and value
     */
    private fun getFormattedParams(params: Map<String, String>?): String {

        val builder = StringBuilder()

        if (params != null) {

            builder.append("?")

            // I'm using for instead of forEach because the minSdk is set to 21
            // and forEach needs minSdk 24
            for ((key, value) in params) {
                builder.append(key)
                builder.append("=")
                builder.append(value)
            }
        }

        return builder.toString()
    }

    /**
     * Read the response values and return as JSONArray
     *
     * @param apiConnection Http connection
     */
    private fun readResponseMessage(apiConnection: HttpURLConnection): JSONArray {

        val reader = BufferedReader(InputStreamReader(apiConnection.inputStream))
        val builder = StringBuilder()
        var response = reader.readLine()

        while (!response.isNullOrEmpty()) {
            builder.append(response)
            builder.append("\n")
            response = reader.readLine()
        }
        reader.close()

        return JSONArray(builder.toString())
    }

    /**
     * Send a message to server
     *
     * @param endpoint Endpoint
     * @param method HttpMethod
     * @param params Mapper with key and value
     * @return a JSONObject
     */
    override fun send(endpoint: Endpoint, method: HttpMethod, params: JSONObject) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}