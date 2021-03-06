package com.developer.joe.cryptoshift.dbaccess.service

import com.developer.joe.cryptoshift.CryptoCoin

/**
 * Interface used to insert coins on database
 *
 * @author Joemerson Souza
 */
interface InsertCryptoValues {

    /**
     * Insert a CryptoCoin into a repository
     *
     * @param cryptoCoin Crypto coin object
     */
    fun insert(cryptoCoin: CryptoCoin)
}