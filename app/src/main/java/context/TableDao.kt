package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.tableDto

@Dao
interface TableDao{
    @Query("Select *  from tables where id = :id")
    fun get(id : Long) : List<tableDto>
    @Query("Select *  from tables")
    fun getAll() : List<tableDto>
    @Insert
    fun insert(tableDto: tableDto)
    @Query("delete  from tables")
    fun clear()
}