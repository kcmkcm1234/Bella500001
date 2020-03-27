package com.suftnet.api

interface baseCallBack<in T: Any> {
    fun onResponse(response: T)
    fun onFailure(error: errorResponse)
}