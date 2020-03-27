package com.suftnet.context

import android.arch.persistence.room.*
import com.suftnet.model.userDto

@Dao
interface UserDao{
    @Query("Select *  from user")
    fun get() : List<userDto>
    @Insert
    fun insert(userDto: userDto)
    @Query("delete  from user")
    fun clear()
}