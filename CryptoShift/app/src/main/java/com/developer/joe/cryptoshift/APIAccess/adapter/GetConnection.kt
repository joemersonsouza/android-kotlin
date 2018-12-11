package com.developer.joe.cryptoshift.APIAccess.adapter

import com.developer.joe.cryptoshift.APIAccess.HttpMethod
import java.net.HttpURLConnection
import java.net.URL

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
    fun get(method: HttpMethod, url: URL): HttpURLConnection?
}