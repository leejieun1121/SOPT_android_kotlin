package com.example.sopt_0423_3

import android.app.Application

class App : Application() {
    companion object{
        lateinit var users : MySharedPreferences
    }

    override fun onCreate() {
        users = MySharedPreferences(applicationContext)
        super.onCreate()

    }
}