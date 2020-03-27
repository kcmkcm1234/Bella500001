package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.itemDto

object itemService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<itemDto>>){
        Http.authGet(Constants.ITEM_URL,accessToken, Array<itemDto>::class.java, callBack)
    }

}