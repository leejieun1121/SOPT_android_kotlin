package com.example.sopt_0518.data

import android.app.Application

class App : Application() {
    companion object{
        lateinit var users : MySharedPreferences
    }

    override fun onCreate() {
        users =
            MySharedPreferences(applicationContext)
        super.onCreate()

    }
}