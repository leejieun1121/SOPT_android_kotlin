package com.example.sopt_0518.network

import com.example.sopt_0518.data.RequestLogin
import com.example.sopt_0518.data.ResponseLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface  RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}