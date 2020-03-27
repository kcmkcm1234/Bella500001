package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.itemDto

@Dao
interface ItemDao {
    @Query("Select *  from item where id = :id")
    fun get(id : Long) : List<itemDto>
    @Query("Select *  from item")
    fun getAll() : List<itemDto>
    @Insert
    fun insert(itemDto: itemDto)
    @Query("delete  from item")
    fun clear()
}