package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.floorDto

object floorService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<floorDto>>){
        Http.authGet(Constants.FLOOR_URL,accessToken, Array<floorDto>::class.java, callBack)
    }

}