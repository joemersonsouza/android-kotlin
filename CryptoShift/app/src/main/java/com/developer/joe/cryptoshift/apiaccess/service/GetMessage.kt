package com.developer.joe.cryptoshift.apiaccess.service

import com.developer.joe.cryptoshift.apiaccess.Endpoint
import org.json.JSONArray

/**
 * Interface used to get a message from server
 *
 */
interface GetMessage {

    /**
     * Get a message from server
     *
     * @param endpoint Endpoint
     * @param params Mapper with key and value
     * @return a JSONObject
     */
    fun get(endpoint: Endpoint, params: Map<String, String>?) : JSONArray
}