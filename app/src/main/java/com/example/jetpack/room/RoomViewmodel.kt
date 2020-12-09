package com.example.jetpack.room

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RoomViewModel(application:Application):AndroidViewModel(application) {
     suspend fun insertIntoDB(context: Context){
        val dummyResponseList = ArrayList<DummyResponse>()
        for(i in 0..10){
            val dummyResponse = DummyResponse(coltrl = "Coltrl"+i,
                ldgrAmt = "ldgrAmt"+i,segKey = "segKey"+i,cnstKey = "cnstKey"+i,
                margnReq = "MarginReq"+i,totPay = "totPay"+i,minpay = "Minpay"+i,name ="name"+1)
            dummyResponseList.add(dummyResponse)
        }
        Log.d("insertUserDetails", "insertUserDetails: "+dummyResponseList.size)


//                AppDatabase(getApplication()).dummyDao().insertAll(dummyResponseList[0])



    }
    suspend fun fetchDetails(){
        val dummyResponseList = ArrayList<DummyResponse>()
        for(i in 0..10){
            val dummyResponse = DummyResponse(coltrl = "Coltrl"+i,
                    ldgrAmt = "ldgrAmt"+i,segKey = "segKey"+i,cnstKey = "cnstKey"+i,
                    margnReq = "MarginReq"+i,totPay = "totPay"+i,minpay = "Minpay"+i,name = "name"+1)
            dummyResponseList.add(dummyResponse)
        }
        Log.d("insertUserDetails", "insertUserDetails: "+dummyResponseList.size)


//        AppDatabase(getApplication()).dummyDao().insertAll(dummyResponseList[0])


//        val  aa = AppDatabase(getApplication()).dummyDao().getAll()
//                Log.d("insertUserDetails", "fetch: "+aa.size)

    }


}