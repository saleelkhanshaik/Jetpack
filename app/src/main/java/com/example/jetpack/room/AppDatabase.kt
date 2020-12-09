package com.example.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.locks.Lock
@Database(entities = [DummyResponse::class],version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun dummyDao():DummyDao
    companion object{
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE DummyResponse ADD COLUMN name TEXT")
            }
        }
//        val MIGRATION_2_3 = object : Migration(2, 3){
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("CREATE TABLE IF NOT EXISTS `SamplePojo` ( `fName` TEXT,`mName` TEXT,`lName` TEXT, PRIMARY KEY(`uid`)) ")
//            }
//        }
        @Volatile private var INSTANCE:AppDatabase?=null
        private val Lock = Any()
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(Lock){
            INSTANCE ?: buildDatabase(context).also{
                INSTANCE = it
            }
        }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
        AppDatabase::class.java,
        "DummyData").addMigrations(MIGRATION_1_2).build()
    }


}