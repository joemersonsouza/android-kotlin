package com.developer.joe.cryptoshift

import android.content.Context
import android.net.ConnectivityManager

/**
 * Implement's a service to work with android network
 *
 * @author Joemerson Souza
 */
class NetworkService {

    /**
     * Verify if mobile has some connection with the internet
     *
     * @param context Context
     * @return true if connection is accessible
     */
    fun isConnected(context: Context) : Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivity.activeNetworkInfo.isConnected
                && !connectivity.activeNetworkInfo.isAvailable
    }
}