package com.developer.joe.cryptoshift

import com.fasterxml.jackson.databind.ObjectMapper
import org.json.JSONObject

/**
 * CryptoCoin model
 *
 * @property symbol The crypto coin Symbol i.e. LTC, BTC
 * @property price The crypto coin price's
 * @author Joemerson Souza
 */
class CryptoCoin (val symbol:String, val price:Long)