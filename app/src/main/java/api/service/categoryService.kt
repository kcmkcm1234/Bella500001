package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.categoryDto

object categoryService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<categoryDto>>){
        Http.authGet(Constants.CATEGORY_URL,accessToken, Array<categoryDto>::class.java, callBack)
    }

}