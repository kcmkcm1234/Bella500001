package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.discountDto

@Dao
interface DiscountDao{
    @Query("Select *  from discount where id = :id")
    fun get(id : Long) : List<discountDto>
    @Query("Select *  from discount")
    fun getAll() : List<discountDto>
    @Insert
    fun insert(discountDto: discountDto)
    @Query("delete  from discount")
    fun clear()
}