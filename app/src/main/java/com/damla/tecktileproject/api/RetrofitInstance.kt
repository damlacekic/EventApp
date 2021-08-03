package com.damla.tecktileproject.api

import retrofit2.converter.moshi.MoshiConverterFactory

import com.damla.tecktileproject.api.Constant.Companion.BASE_URL
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitInstance {
/*
   private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
*/


    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
           // .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()
    }
    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}