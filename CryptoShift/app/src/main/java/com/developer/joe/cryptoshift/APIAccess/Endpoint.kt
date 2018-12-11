package com.developer.joe.cryptoshift.APIAccess

enum class Endpoint(name: String) {

    PRICE("ticker/price");

    override fun toString(): String {
        return this.name
    }
}