package com.example.sopt_0518.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object : 싱글톤 선언, 아무데서나 접근 가능하지만 객체는 하나만 생성되어 공유
object RequestToServer{
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create()) //json데이터를 데이터 클래스로 변환 쉽게 해줌
        .build()

    //retrofit 객체 create 호출 , interface 클래스 타입을 넘겨 실제 구현체를 만들어줌
    var service : RequestInterface = retrofit.create(RequestInterface::class.java)

}