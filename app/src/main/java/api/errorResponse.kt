package com.suftnet.api

class errorResponse (val timestamp: String? = null,
                     val status: Int = 0,
                     val error: String = "",
                     val message: String = "",
                     val path: String? = null){

    fun getMsg(): String {
        return "$status $error: $message"
    }
}