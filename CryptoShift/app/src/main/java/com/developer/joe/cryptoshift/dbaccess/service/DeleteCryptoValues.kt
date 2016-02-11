package com.developer.joe.cryptoshift.dbaccess.service

import com.developer.joe.cryptoshift.CryptoCoin

/**
 * Interface used to delete coins on database
 *
 * @author Joemerson Souza
 */
interface DeleteCryptoValues {
    /**
     * Delete all Crypto Coin into a repository
     *
     */
    fun deleteAll()
}