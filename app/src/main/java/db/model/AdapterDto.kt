package com.suftnet.model

class AdapterDto {
    var discounts: MutableList<discountDto> = ArrayList()
    var floors: MutableList<floorDto> = ArrayList()
    var items: MutableList<itemDto> = ArrayList()
    var tables: MutableList<tableDto> = ArrayList()
    var tax: MutableList<taxDto> = ArrayList()
    var tenant: tenantDto? = null
    var user: userDto? = null
    var addon: MutableList<addonDto> = ArrayList()
    var categories:  MutableList<categoryDto> = ArrayList()
}