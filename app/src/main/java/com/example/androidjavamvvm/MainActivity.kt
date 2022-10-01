package com.example.retrofittestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidjavamvvm.R
import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finding the button
        val showButton = findViewById<Button>(R.id.showInput)

        // finding the edit text
        val editText = findViewById<EditText>(R.id.editText)

        // Setting On Click Listener
        showButton.setOnClickListener {

            // Getting the user input
            val email = editText.text.toString()

            // call Api on Button Click
            callApi(email)
        }
    }

    private fun callApi(email : String){

        val URLString = "event_app/wrapper_api/email_lookup/?key=3cdeaf6b02ea5ee3a0ac35b72f&email=$email&device_id=b1ea6e13e5ddac51&os=Android&app_version=1.0&os_version=12&device_type=tab &fcm_token=123445"

        val authCall: Call<JsonObject>? = API.retrofit.create(AppDataService::class.java).getResponse(URLString)
        authCall!!.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful) {
                    Log.d("APITest-Success", "" + response.body())

                    val  gson = Gson()
                    val createUserModel: CreateUserModel =
                        gson.fromJson<CreateUserModel>(
                            response.body().toString(),
                            CreateUserModel::class.java
                        )
                    Toast.makeText(applicationContext,""+createUserModel.shows[0].loginUrl,Toast.LENGTH_LONG).show()
                }

                if(response.code() == 400 || response.code() == 401){
                    if (!response.isSuccessful) {
                        var jsonObject: JSONObject? = null

                        jsonObject = JSONObject(response.errorBody()!!.string())
                        val userMessage = jsonObject.optString("message")
                        Toast.makeText(applicationContext,"email Inavlid" + userMessage,Toast.LENGTH_LONG).show()

                    }
                }

            }

            override fun onFailure(call: Call<JsonObject>, throwable: Throwable) {
                Log.d("APITest-Fail", "" + throwable.message)
            }
        })

//        val chetu : Call<JsonObject> = ChetuService.chetuInstance.getResponse(URLString)
//        chetu.enqueue(object : Callback<JsonObject>{
//            override fun onResponse(
//                call: Call<JsonObject>,
//                response: Response<JsonObject>
//
//            ) {
//
//                if(response.isSuccessful){d
//                    val  gson = Gson()
//                    val createUserModel: CreateUserModel =
//                        gson.fromJson<CreateUserModel>(
//                            response.body().toString(),
//                            CreateUserModel::class.java
//                        )
//                    Log.d("APITest-Success", "" + response.body().toString())
//                    Toast.makeText(applicationContext,""+createUserModel.shows[0].loginUrl,Toast.LENGTH_LONG).show()
//
//                }
//
//                if(response.code() == 400 || response.code() == 401){
//                    if (!response.isSuccessful) {
//                        var jsonObject: JSONObject? = null
//
//                        jsonObject = JSONObject(response.errorBody()!!.string())
//                        val userMessage = jsonObject.optString("message")
//                        Toast.makeText(applicationContext,"email Inavlid" + userMessage,Toast.LENGTH_LONG).show()
//
//                    }
//                }
//
//
//            }
//
//
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                Log.d("APITest-Fail", "" + t.message)
//            }
//        })
//
//    }


}
}