package com.developer.joe.cryptoshift.APIAccess.adapter

import com.developer.joe.cryptoshift.APIAccess.HttpMethod
import java.net.HttpURLConnection
import java.net.URL

/**
 * Implementation of available methods of ApiAdapter
 *
 * @author Joemerson Souza
 */
class ApiAdapterImpl : GetConnection {

    /**
     * Method responsible to return a HttpUrlConnection based on
     * HttpMethod and an url connection
     *
     * @param method HttpMethod
     * @param url Url connect
     */
    override fun get(method: HttpMethod, url: URL): HttpURLConnection? {

        val connection = url.openConnection() as HttpURLConnection
        connection.readTimeout = 15000
        connection.connectTimeout = 15000
        connection.requestMethod = method.toString()
        connection.doInput = true
        connection.setRequestProperty("Connection", "Keep-Alive")
        connection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0")
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")
        connection.doOutput = true
        return connection
    }
}