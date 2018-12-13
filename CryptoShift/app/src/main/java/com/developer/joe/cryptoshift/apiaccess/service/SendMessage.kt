package com.developer.joe.cryptoshift.apiaccess.service

import com.developer.joe.cryptoshift.apiaccess.Endpoint
import com.developer.joe.cryptoshift.apiaccess.HttpMethod
import org.json.JSONObject

/**
 * Interface used to send a message to server
 *
 */
interface SendMessage {

    /**
     * Send a message to server
     *
     * @param endpoint Endpoint
     * @param method HttpMethod
     * @param params Mapper with key and value
     * @return a JSONObject
     */
    fun send(endpoint: Endpoint, method: HttpMethod, params: JSONObject)
}