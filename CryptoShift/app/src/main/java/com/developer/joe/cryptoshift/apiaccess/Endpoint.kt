package com.developer.joe.cryptoshift.apiaccess

enum class Endpoint(name: String) {

    PRICE("ticker/price");

    override fun toString(): String = name
}