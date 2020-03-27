package app

import android.content.Context
import com.suftnet.api.baseCallBack
import com.suftnet.api.errorResponse
import com.suftnet.api.service.AppService
import com.suftnet.context.*
import com.suftnet.model.AdapterDto

class boostrap {

    var context : Context? = null
    var table : TableDao? = null
    var category : CategoryDao? = null
    var floor : FloorDao? = null
    var discount : DiscountDao? = null
    var item : ItemDao? = null
    var tax : TaxDao? = null

    constructor(context : Context){
       this.context = context
        init(DbContext.getInstance(context))
    }

    private fun init(instance : DbContext?)
    {
        table = instance?.tableDao
        floor = instance?.floorDao
        category = instance?.categoryDao
        discount = instance?.discountDao
        item = instance?.itemDao
        tax = instance?.taxDao
    }

    fun start(passCode : String,externalId: String){

        AppService.init(passCode,externalId, object : baseCallBack<AdapterDto> {
            override fun onResponse(response: AdapterDto) {
                load(response)
            }

            override fun onFailure(error: errorResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    fun load(items:AdapterDto)
    {
        Thread {

            table?.clear()
            for (line in items.tables) {
                table?.insert(line)
            }
        }.start()

        Thread {

            floor?.clear()
            for (line in items.floors) {
                floor?.insert(line)
            }
        }.start()

        Thread {

            category?.clear()
            for (line in items.categories) {
                category?.insert(line)
            }
        }.start()

        Thread {

            discount?.clear()
            for (line in items.discounts) {
                discount?.insert(line)
            }
        }.start()


        Thread {

            item?.clear()
            for (line in items.items) {
                item?.insert(line)
            }
        }.start()

        Thread {

            tax?.clear()
            for (line in items.tax) {
                tax?.insert(line)
            }
        }.start()
    }

}