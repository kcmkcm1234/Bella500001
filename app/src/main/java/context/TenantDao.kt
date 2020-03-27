package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.cartDto
import com.suftnet.model.tenantDto
import com.suftnet.model.userDto

@Dao
interface TenantDao{
    @Query("Select *  from tenant")
    fun get() : List<tenantDto>
    @Insert
    fun insert(cartDto: tenantDto)
    @Query("delete  from tenant")
    fun clear()
}