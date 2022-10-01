package com.example.retrofittestapp

import com.google.gson.annotations.SerializedName

class CreateUserModel {
    @SerializedName("email" ) var email : String?          = null
    @SerializedName("shows" ) var shows : ArrayList<Shows> = arrayListOf()
}

