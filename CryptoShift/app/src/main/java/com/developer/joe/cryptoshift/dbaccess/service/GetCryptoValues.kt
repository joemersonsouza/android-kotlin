package com.developer.joe.cryptoshift.dbaccess.service

import com.developer.joe.cryptoshift.CryptoCoin

/**
 * Interface used to get coins on database
 *
 * @author Joemerson Souza
 */
interface GetCryptoValues {
    /**
     * Insert a CryptoCoin into a repository
     *
     * @return cryptoCoin Crypto coin object
     */
    fun get() : ArrayList<CryptoCoin>
}