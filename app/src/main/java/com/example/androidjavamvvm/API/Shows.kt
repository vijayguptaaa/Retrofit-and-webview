package com.example.retrofittestapp

import com.google.gson.annotations.SerializedName


class Shows {
    @SerializedName("code"        ) var code       : String? = null
    @SerializedName("name"        ) var name       : String? = null
    @SerializedName("attendee_id" ) var attendeeId : Int?    = null
    @SerializedName("reg_type_id" ) var regTypeId  : Int?    = null
    @SerializedName("login_url"   ) var loginUrl   : String? = null
    @SerializedName("graphic"     ) var graphic    : String? = null

}