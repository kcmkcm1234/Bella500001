package com.suftnet.api

import com.google.gson.GsonBuilder
import com.suftnet.constant.Constants
import okhttp3.*
import java.io.IOException

object Http {

    private val hostUrl = Constants.HOST_URL
    private val gson = GsonBuilder().create()
    private val mediaType = MediaType.parse("application/json")
    private val client = OkHttpClient()

    fun get(url: String, responseClass: Class<out Any>, callbackAny: Any) {
        val request = Request.Builder()
            .url("$hostUrl$url").get().build()

        runRequest(request, responseClass, callbackAny)
    }

    fun post(url: String, body: Any?, responseClass: Class<out Any>, callbackAny: Any) {
        val request = Request.Builder()
            .url("$hostUrl$url").post(RequestBody.create(mediaType, validateRequestBody(body))).build()
        runRequest(request, responseClass, callbackAny)
    }

    fun put(url: String, body: Any?, responseClass: Class<out Any>, callbackAny: Any) {
        val request = Request.Builder()
            .url("$hostUrl$url").put(RequestBody.create(mediaType, validateRequestBody(body))).build()
        runRequest(request, responseClass, callbackAny)
    }

    fun delete(url: String, callback: voidCallBack) {
        val request = Request.Builder()
            .url("$hostUrl$url").delete().build()
        runVoidRequest(request, callback)
    }

    fun authGet(url: String, accessToken : String, responseClass: Class<out Any>, callbackAny: Any) {

        val request = Request.Builder()
            .url("$hostUrl$url")
            .get()
            .addHeader("Authorization", "bearer $accessToken").build()
        runRequest(request, responseClass, callbackAny)
    }

    fun authPost(url: String, accessToken : String, body: Any?, responseClass: Class<out Any>, callbackAny: Any) {

        val request = Request.Builder()
            .url("$hostUrl$url")
            .post(RequestBody.create(mediaType, validateRequestBody(body)))
            .addHeader("Authorization", "bearer $accessToken").build()
        runRequest(request, responseClass, callbackAny)
    }

    fun authPut(url: String, accessToken : String, body: Any?, responseClass: Class<out Any>, callbackAny: Any) {
        val request = Request.Builder()
            .url("$hostUrl$url")
            .put(RequestBody.create(mediaType, validateRequestBody(body)))
            .addHeader("Authorization", "bearer $accessToken").build()
        runRequest(request, responseClass, callbackAny)
    }

    fun authDelete(url: String, accessToken : String, callback: voidCallBack) {
        val request = Request.Builder()
            .url("$hostUrl$url")
            .delete()
            .addHeader("Authorization", "bearer $accessToken").build()
        runVoidRequest(request, callback)
    }

    private fun runVoidRequest(request: Request, callback: voidCallBack) {
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if(response.code() == 200) {
                    callback.onResponse()
                } else {
                    val body = response.body()?.string()
                    val result = gson.fromJson(body, errorResponse::class.java)
                    callback.onFailure(result)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(errorResponse())
            }
        })
    }

    @Suppress("UNCHECKED_CAST")
    private fun convertCallBack(callback: Any): baseCallBack<Any> {
        return callback as baseCallBack<Any>
    }

    private fun runRequest(request: Request, responseClass: Class<out Any>, callbackAny: Any) {
        val callback = convertCallBack(callbackAny)
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                handleResponse(response, responseClass, callback)
            }

            override fun onFailure(call: Call, e: IOException) {
                callback.onFailure(errorResponse())
            }
        })
    }

    private fun handleResponse(response: Response, bodyClass: Class<out Any>, callback: baseCallBack<Any>) {
        if(response.code() == 200) {
            val body = response.body()?.string()
            val result = gson.fromJson(body, bodyClass)
            callback.onResponse(result)
        } else {
            val body = response.body()?.string()
            val result = gson.fromJson(body, errorResponse::class.java)
            callback.onFailure(result)
        }
    }

    private fun validateRequestBody(body: Any?) : String {
        return when (body is String) {
            true -> return body
            false -> gson.toJson(body)
        }
    }

}