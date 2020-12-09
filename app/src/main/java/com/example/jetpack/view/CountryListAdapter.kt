package com.example.jetpack.view

import android.app.Activity
import android.content.Context
import android.transition.CircularPropagation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.example.jetpack.R
import com.example.jetpack.model.ResponseData
import kotlinx.android.synthetic.main.countrylist.view.*

class CountryListAdapter(private val context:Context,private val list:List<ResponseData>,private val act:Activity): RecyclerView.Adapter<CountryListAdapter.ItemHolder>() {
     class ItemHolder(private val view:View) :RecyclerView.ViewHolder(view){
         val flagImg = view.flagImg
         val countryName = view.countryName
         val countryCode = view.countryCallingCode
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(context).inflate(R.layout.sample,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val responseData = list[position]
        holder.countryName.text=responseData.name
        holder.countryCode.text= "+"+responseData.callingCodes?.get(0) ?: ""
        //Glide.with(context).load(responseData.flag).into(holder.flagImg)
//        SvgLoader.pluck()
//            .with(act)
//            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
//            .load(responseData.flag, holder.flagImg);

//        GlideApp.with(context).load(responseData.flag).
//        apply(RequestOptions.centerCropTransform()).into(holder.flagImg);
        val imageLoader = ImageLoader.Builder(context).componentRegistry {
            add(SvgDecoder(context))
        }.build()
//        Coil.apply(imageLoader)
        Coil.setImageLoader(imageLoader)
        holder.flagImg.load(responseData.flag)
    }
}