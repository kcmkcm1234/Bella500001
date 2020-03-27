package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.floorDto

@Dao
interface FloorDao{
    @Query("Select *  from floor where id = :id")
    fun get(id : Long) : List<floorDto>
    @Query("Select *  from floor")
    fun getAll() : List<floorDto>
    @Insert
    fun insert(floorDto: floorDto)
    @Query("delete  from floor")
    fun clear()
}