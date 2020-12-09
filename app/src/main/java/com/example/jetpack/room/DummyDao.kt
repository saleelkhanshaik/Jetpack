package com.example.jetpack.room

import androidx.room.*

@Dao
interface DummyDao {
    //insert Query
    @Insert
    suspend fun insertAll(vararg dummyResponse:DummyResponse):List<Long>

    //delete Query
    @Delete
    fun deleteAll(dummyResponse: DummyResponse)

    @Query("SELECT * FROM dummyresponse")
    suspend fun getAll():List<DummyResponse>

    @Query("SELECT * FROM dummyresponse WHERE segKey LIKE:segKey AND cnstKey LIKE:cnsKey LIMIT 1")
    fun findBySegCnsKey(segKey:String,cnsKey:String):DummyResponse

    @Query("SELECT * FROM dummyresponse WHERE segKey IN (:segKeys)")
    fun loadAllBySegKey(segKeys:IntArray):List<DummyResponse>
}