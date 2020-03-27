package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.categoryDto
import com.suftnet.model.orderDto

object orderService {

    fun create(accessToken :String, body: String, callBack: baseCallBack<Boolean>){
        Http.authPost(Constants.ORDER_URL,accessToken,body, Boolean::class.java, callBack)
    }

}