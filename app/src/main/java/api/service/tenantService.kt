package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.tenantDto

object tenantService {

    fun get(accessToken : String, callBack: baseCallBack<tenantDto>){
        Http.authGet(Constants.TENANT_URL,accessToken, tenantDto::class.java, callBack)
    }

}