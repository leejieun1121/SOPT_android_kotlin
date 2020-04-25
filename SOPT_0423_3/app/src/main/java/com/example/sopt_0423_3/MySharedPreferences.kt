package com.example.sopt_0423_3

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (context: Context) {
    val PREFS_FILENAME = "users"
    val PREF_KEY_ID = "myid"
    val PREF_KEY_PW = "mypw"
    val users:SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,0)

    var myid: String
    get() = users.getString(PREF_KEY_ID,"")!!
    set(value) = users.edit().putString(PREF_KEY_ID,value).apply()

    var mypw: String
    get() = users.getString(PREF_KEY_PW,"")!!
    set(value) = users.edit().putString(PREF_KEY_PW,value).apply()
}