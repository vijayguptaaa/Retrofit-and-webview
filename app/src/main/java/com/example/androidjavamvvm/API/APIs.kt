package com.example.retrofittestapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://tools.eventpower.com/")
        .build()
}