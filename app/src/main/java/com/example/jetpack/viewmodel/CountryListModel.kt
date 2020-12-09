package com.example.jetpack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.model.ResponseData
import com.example.jetpack.model.RetrofitAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListModel:ViewModel() {
    private val TAG = "CountryListModel"
    private val countryList:MutableLiveData<List<ResponseData>> by lazy {
        MutableLiveData<List<ResponseData>>().also{
            loadCountry()
        }
    }
    fun getCountryDetails():LiveData<List<ResponseData>>{
        return countryList
    }
    private fun loadCountry(){
        val countryCall = RetrofitAPI.instance.getCountryDetails()
        countryCall.enqueue(object : Callback<List<ResponseData>> {
            override fun onFailure(call: Call<List<ResponseData>>,t: Throwable) {
                Log.d("MAIN ACT" + call.request().url(), ""+t.toString())
            }
            override fun onResponse(
                call: Call<List<ResponseData>>,
                response: Response<List<ResponseData>> ) {
                countryList.value= response.body()
                Log.d("MAIN ACT123" + call.request().url(), ""+countryList.value?.size)
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared: ")
    }

}