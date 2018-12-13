package com.developer.joe.cryptoshift.dbaccess.service

import com.developer.joe.cryptoshift.CryptoCoin

/**
 * Interface used to get a message from server
 *
 */
interface InsertCryptoValues {

    /**
     * Insert a CryptoCoin into a repository
     *
     * @param cryptoCoin Crypto coin object
     */
    fun insert(cryptoCoin: CryptoCoin)
}