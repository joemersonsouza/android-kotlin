package com.developer.joe.cryptoshift.apiaccess.repository

import com.developer.joe.cryptoshift.apiaccess.HttpMethod
import java.net.URL
import javax.net.ssl.HttpsURLConnection

/**
 * Representative interface to get a URL connection
 *
 * @author Joemerson Souza
 */
interface GetConnection {

    /**
     * Method responsible to get and return a HttpURLConnection
     *
     * @param method HttpMethod (PUT,GET, ...)
     * @param url URL to connect
     * @return An HttpURLConnection
     */
    fun get(method: HttpMethod, url: URL): HttpsURLConnection?
}