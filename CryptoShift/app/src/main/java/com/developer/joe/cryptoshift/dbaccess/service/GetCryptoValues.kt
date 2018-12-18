package com.developer.joe.cryptoshift.dbaccess.service

import com.developer.joe.cryptoshift.CryptoCoin

/**
 * Interface used to get coins on database
 *
 * @author Joemerson Souza
 */
interface GetCryptoValues {
    /**
     * Get a list of Crypto Coin into a repository
     *
     * @return cryptoCoin Crypto coin object
     */
    fun get() : ArrayList<CryptoCoin>

    /**
     * Get a list od Crypto Coin into a repository
     * based on search value
     *
     * @return cryptoCoin Crypto coin object
     */
    fun get(search : String) : ArrayList<CryptoCoin>
}