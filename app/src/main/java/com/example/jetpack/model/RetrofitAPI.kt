package com.example.jetpack.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {
    val BASE_URL="https://restcountries.eu/"
    val instance:RetrofitAPIendPoint by lazy {
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build()
        retrofit.create(RetrofitAPIendPoint::class.java)
    }
}