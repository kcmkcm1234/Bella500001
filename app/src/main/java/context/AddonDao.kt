package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.addonDto
import com.suftnet.model.cartDto
import com.suftnet.model.categoryDto

@Dao
interface AddonDao{
    @Query("Select *  from addon where id = :id")
    fun get(id : Long) : List<addonDto>
    @Query("Select *  from addon")
    fun getAll() : List<addonDto>
    @Insert
    fun insert(addonDto: addonDto)
    @Query("delete  from addon")
    fun clear()
}