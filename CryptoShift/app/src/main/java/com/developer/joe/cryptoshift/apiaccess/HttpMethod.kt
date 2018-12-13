package com.developer.joe.cryptoshift.apiaccess

/**
 * HTTP method able to be used on project
 *
 * @author Joemerson Souza
 */
enum class HttpMethod(name:String) {
    HTTP_POST("POST"),
    HTTP_GET("GET"),
    HTTP_PUT("PUT");

    override fun toString(): String {
        return this.name
    }
}