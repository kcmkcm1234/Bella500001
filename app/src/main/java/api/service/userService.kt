package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.AdapterDto
import com.suftnet.model.userDto

object userService {

    fun get(accessToken : String, callBack: baseCallBack<userDto>){
        Http.authGet(Constants.USER_URL,accessToken, userDto::class.java, callBack)
    }

}