package com.developer.joe.cryptoshift.apiaccess

/**
 * Address can be connected to get crypto info
 *
 * @author Joemerson Souza
 */
enum class ApiAddress(private val address: String) {

    BINANCE("https://api.binance.com/api/v3/");

    override fun toString(): String = address
}