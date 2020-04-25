package com.example.sopt_0423_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        et_join.setOnClickListener {
            val loginIntent = Intent()
            loginIntent.putExtra("user_id", et_email.text.toString())
            loginIntent.putExtra("user_pw", et_pw.text.toString())
            //Log.d("join id",id)
            //Log.d("join pw",pw)
            setResult(Activity.RESULT_OK,loginIntent)
            finish()
        }

    }
}