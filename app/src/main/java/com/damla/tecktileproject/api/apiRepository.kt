package com.damla.tecktileproject.api

import com.damla.tecktileproject.api.model.user
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class apiRepository {
    fun  postSignUp(email: String, password: String, fullName: String , username : String) : Call<String> {
        return  RetrofitInstance.api.postSignUp(email,password,fullName,username)
    }

    fun putLogIn(email: String,password: String) : Call<String>{
        return RetrofitInstance.api.putLogIn(email,password)
    }

}