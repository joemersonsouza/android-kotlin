package com.developer.joe.cryptoshift.APIAccess.service

import com.developer.joe.cryptoshift.APIAccess.Endpoint
import com.developer.joe.cryptoshift.APIAccess.HttpMethod
import com.developer.joe.cryptoshift.APIAccess.adapter.ApiAdapterImpl
import com.developer.joe.cryptoshift.APIAccess.adapter.GetConnection
import org.json.JSONObject

/**
 * Api service
 *
 * @author Joemerson Souza
 */
class ApiService : GetMessage, SendMessage {

    /**
     * Get a message from server
     *
     * @param endpoint Endpoint
     * @param params Mapper with key and value
     * @return a JSONObject
     */
    override fun get(endpoint: Endpoint, params: Map<String, String>): JSONObject {

        checkNotNull(params)

        return JSONObject()
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