package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.lineItemDto

@Dao
interface LineItemDao{
    @Query("Select *  from lineItem")
    fun getAll() : List<lineItemDto>
    @Insert
    fun insert(lineItemDto: lineItemDto)
    @Update
    fun update(lineItemDto: lineItemDto)
    @Delete
    fun delete(lineItemDto: lineItemDto)
    @Query("delete  from lineItem")
    fun clear()
}