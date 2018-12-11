package com.developer.joe.cryptoshift.APIAccess.service

import com.developer.joe.cryptoshift.APIAccess.Endpoint
import org.json.JSONObject

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
    fun get(endpoint: Endpoint, params: Map<String, String>) : JSONObject
}