package com.suftnet.api.service

import com.suftnet.api.Http
import com.suftnet.api.baseCallBack
import com.suftnet.constant.Constants
import com.suftnet.model.tableDto

object tableService {

    fun getAll(accessToken : String, callBack: baseCallBack<Array<tableDto>>){
        Http.authGet(Constants.TABLE_URL,accessToken, Array<tableDto>::class.java, callBack)
    }

}