package com.example.retrofittestapp

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Url

interface AppDataService {
    @GET
    fun getResponse(@Url url: String?): Call<JsonObject>
}


//object ChetuService{
//    val chetuInstance :  AppDataService
//    init {
//        var retrofit = Retrofit.Builder()
//            .baseUrl("https://tools.eventpower.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        chetuInstance = retrofit.create(AppDataService::class.java)
//    }
//}