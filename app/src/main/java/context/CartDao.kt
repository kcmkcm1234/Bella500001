package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.cartDto

@Dao
interface CartDao{
    @Query("Select *  from cart")
    fun getAll() : List<cartDto>
    @Insert
    fun insert(cartDto: cartDto)
    @Update
    fun update(cartDto: cartDto)
    @Delete
    fun delete(cartDto: cartDto)
    @Query("delete  from cart")
    fun clear()
}