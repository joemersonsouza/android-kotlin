package com.developer.joe.cryptoshift.APIAccess

/**
 * Address can be connected to get crypto info
 *
 * @author Joemerson Souza
 */
enum class ApiAddress(address: String) {

    BINNANCE("https://api.binance.com/api/v3/");

    override fun toString(): String {
        return this.name;
    }
}