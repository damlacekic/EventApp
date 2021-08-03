package com.damla.tecktileproject.api

import com.damla.tecktileproject.api.model.user
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class apiRepository {
    suspend  fun  postSignUp(email: String, password: String, fullName: String , username : String) : Response<ResponseBody> {
        return  RetrofitInstance.api.postSignUp(email,password,fullName,username)
    }

    suspend fun putLogIn(email: String,password: String) : Response<ResponseBody>{
        return RetrofitInstance.api.putLogIn(email,password)
    }

}