package com.developer.joe.cryptoshift.dbaccess.repository

/**
* SQL Actions able to the system
*
* @author Joemerson Souza
**/
enum class DbAction(private val script: String) {
    CREATE_CRYPTO_TABLE("CREATE TABLE CRYPTOCOINS (SYMBOL VARCHAR(150), PRICE VARCHAR(100));"),
    DROP_CRYPTO_TABLE("DROP TABLE CRYPTOCOINS;");
    
    override fun toString() : String = script
}
