package com.suftnet.api

interface GetCallBack {
    fun onResponse(accesToken: String)
    fun onFailure(errMessage: String)
}

interface ValidateCallback {
    fun onResponse()
    fun onFailure(errMessage: String? = null)
}