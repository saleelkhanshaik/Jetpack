package com.example.jetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack.model.ResponseData
import com.example.jetpack.view.CountryListAdapter
import com.example.jetpack.viewmodel.CountryListModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        val model: CountryListModel by viewModels()
        model.getCountryDetails().observe(this, Observer<List<ResponseData>> {
            it.let {
                Log.d(TAG, "onCreate: " + it.size)
                return@let countryList.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = CountryListAdapter(this@MainActivity, it,this@MainActivity)
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}