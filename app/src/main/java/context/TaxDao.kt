package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.taxDto

@Dao
interface TaxDao{
    @Query("Select *  from tax where id = :id")
    fun get(id : Long) : List<taxDto>
    @Query("Select * from tax")
    fun getAll() : List<taxDto>
    @Insert
    fun insert(taxDto: taxDto)
    @Query("delete  from tax")
    fun clear()
}