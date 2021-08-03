package com.damla.tecktileproject.api

import com.damla.tecktileproject.api.model.user
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {
    @FormUrlEncoded
    @POST("/api/v1/entrance/signup")
    suspend fun postSignUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("fullName") fullName: String,
        @Field("username") username: String,
    ) : Response<ResponseBody>


    @FormUrlEncoded
    @PUT("/api/v1/entrance/login")
    suspend fun putLogIn(
        @Field("email") email: String,
        @Field("password") password: String,
    ) :Response<ResponseBody>
}