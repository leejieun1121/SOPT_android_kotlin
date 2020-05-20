package com.example.sopt_0518.data

import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
//    @SerializedName("data")
//    //서버에서 정한 변수 말고 직접 이름을 지을수도 있음
//    val responseData : SomeData?
)

data class SomeData(
    val jwt : String
)