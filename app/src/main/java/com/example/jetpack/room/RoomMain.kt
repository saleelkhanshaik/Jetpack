package com.example.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.jetpack.R
import kotlinx.android.synthetic.main.activity_room_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class RoomMain : AppCompatActivity() {
//    private var appDatabase:DummyDao?=null

    private val TAG = "RoomMain"
    private var model:RoomViewModel ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)
        //appDatabase = AppDatabase.invoke(this@RoomMain).dummyDao()
        model = ViewModelProvider(this@RoomMain).get(RoomViewModel::class.java)
//        button.setOnClickListener { insertUserDetails() }
//        button2.setOnClickListener { fetchDetailsFromDB() }
        lifecycleScope.launch {
            //insertUserDetails()
        }
        lifecycleScope.launch {
            //fetchDetailsFromDB()
//            sampleDataInsert()
        }
    }

    private suspend fun fetchDetailsFromDB() {
//    model?.fetchDetails()
        val dummyResponseList = ArrayList<DummyResponse>()
        for(i in 0..10){
            val dummyResponse = DummyResponse(coltrl = "Coltrl"+i,
                    ldgrAmt = "ldgrAmt"+i,segKey = "segKey"+i,cnstKey = "cnstKey"+i,
                    margnReq = "MarginReq"+i,totPay = "totPay"+i,minpay = "Minpay"+i,name = "name"+i)
            dummyResponseList.add(dummyResponse)
        }
        AppDatabase.invoke(this@RoomMain).dummyDao().insertAll(*dummyResponseList.toTypedArray())
        Log.d("insertUserDetails", "insertUserDetails: "+dummyResponseList.size)


       val  li = AppDatabase.invoke(this@RoomMain).dummyDao().getAll()
        Log.d("insertUserDetails", "insertUserDetails: "+li.size+" ---- "+li[0].name)
        for(i in li.indices){
            Log.d(TAG,"insertUserDetails "+li[i].name)
        }
    }

    private suspend fun insertUserDetails() {
        model?.insertIntoDB(this@RoomMain)

    }
}