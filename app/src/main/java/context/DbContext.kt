package com.suftnet.context

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.suftnet.model.*

@Database(entities = [cartDto::class, floorDto ::class, itemDto ::class,categoryDto ::class
,discountDto ::class,taxDto ::class,tableDto ::class,lineItemDto ::class, orderDto ::class], version = 1,  exportSchema = false)
abstract class DbContext : RoomDatabase(){
    abstract  val tableDao: TableDao
    abstract  val categoryDao : CategoryDao
    abstract  val cartDao : CartDao
    abstract  val floorDao : FloorDao
    abstract  val taxDao : TaxDao
    abstract  val discountDao : DiscountDao
    abstract  val itemDao : ItemDao
    abstract  val orderDao : OrderDao
    abstract  val lineItemDao : LineItemDao

    companion object {

        @Volatile
        private var INSTANCE: DbContext? = null
        fun getInstance(context: Context): DbContext?
        {
            var instance  = INSTANCE

            synchronized(this)
            {
                if (instance == null)
                {
                    instance = Room.databaseBuilder(context.applicationContext, DbContext::class.java, "bella.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
                INSTANCE = instance
            }
            return instance
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}