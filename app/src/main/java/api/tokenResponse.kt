package com.suftnet.api

class tokenResponse( val access_token: String,
val refresh_token: String,
val tokenType: String,
val expires_in: Int,
val scope: String,
val jti: String)