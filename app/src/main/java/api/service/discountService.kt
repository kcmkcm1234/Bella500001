package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.discountDto

object discountService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<discountDto>>){
        Http.authGet(Constants.DISCOUNT_URL,accessToken, Array<discountDto>::class.java, callBack)
    }

}