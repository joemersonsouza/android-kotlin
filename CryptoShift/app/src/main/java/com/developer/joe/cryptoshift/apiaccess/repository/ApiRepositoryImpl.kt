package com.developer.joe.cryptoshift.apiaccess.repository

import com.developer.joe.cryptoshift.apiaccess.HttpMethod
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Implementation of available methods of ApiAdapter
 *
 * @author Joemerson Souza
 */
class ApiRepositoryImpl : GetConnection {

    /**
     * Method responsible to return a HttpUrlConnection based on
     * HttpMethod and an url connection
     *
     * @param method HttpMethod
     * @param url Url connect
     */
    override fun get(method: HttpMethod, url: URL): HttpsURLConnection? {

        val connection : HttpsURLConnection = url.openConnection() as HttpsURLConnection
        connection.readTimeout = 15000
        connection.connectTimeout = 15000
        connection.requestMethod = method.toString()
        connection.doInput = true
        connection.doOutput = true
        connection.setRequestProperty("Connection", "Keep-Alive")
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8")
        return connection
    }
}