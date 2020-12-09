package com.example.jetpack.model

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPIendPoint {
    @GET("rest/v2/all")
    fun getCountryDetails():Call<List<ResponseData>>
}