package com.developer.joe.cryptoshift.apiaccess

enum class Endpoint(val address: String) {

    PRICE("ticker/price");

    override fun toString(): String = address
}