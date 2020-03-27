package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.taxDto

object taxService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<taxDto>>){
        Http.authGet(Constants.TAX_URL,accessToken, Array<taxDto>::class.java, callBack)
    }

}