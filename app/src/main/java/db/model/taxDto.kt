package com.suftnet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "tax")
data class taxDto  (

    @ColumnInfo(name = "movieName") var movieName: String,
    @ColumnInfo(name="id") @PrimaryKey(autoGenerate = true)  var id: Long = 0)