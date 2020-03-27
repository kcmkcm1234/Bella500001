package com.suftnet.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class userDto  (
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "mobile") var mobile: String,
    @ColumnInfo(name = "token") var token: String,
    @ColumnInfo(name = "active") var active: Boolean,
    @ColumnInfo(name = "externalId") var externalId: String,
    @ColumnInfo(name="id") @PrimaryKey(autoGenerate = true)  var id: Long = 0)
