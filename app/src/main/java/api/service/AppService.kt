package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.AdapterDto

object AppService {

    fun init(passCode : String, externalId : String, callBack: baseCallBack<AdapterDto>){
        Http.get(Constants.APP_URL +"/$passCode/$externalId", AdapterDto::class.java, callBack)
    }

}