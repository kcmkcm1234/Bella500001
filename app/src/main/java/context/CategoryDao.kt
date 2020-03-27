package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.cartDto
import com.suftnet.model.categoryDto

@Dao
interface CategoryDao{
    @Query("Select *  from category where id = :id")
    fun get(id : Long) : List<categoryDto>
    @Query("Select *  from category")
    fun getAll() : List<categoryDto>
    @Insert
    fun insert(categoryDto: categoryDto)
    @Query("delete  from category")
    fun clear()
}