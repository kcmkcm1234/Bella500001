package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.orderDto

@Dao
interface OrderDao{
    @Query("Select *  from orders")
    fun getAll() : List<orderDto>
    @Insert
    fun insert(orderDto: orderDto)
    @Update
    fun update(orderDto: orderDto)
    @Delete
    fun delete(orderDto: orderDto)
    @Query("delete  from orders")
    fun clear()
}