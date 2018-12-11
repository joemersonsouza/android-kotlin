package com.developer.joe.cryptoshift.Exception

import java.lang.Exception

/**
 * Exception to be used when the server is not available
 *
 * @author Joemerson Souza
 */
class ServerUnavailableException(message: String?) : Exception(message) {

    /**
     * Message that will be used to show when the exception occurring
     */
    fun getErrorMessage() : String {
        return "Server Unavaible at moment, please try again later";
    }
}