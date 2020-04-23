package com.example.sopt_0423_1

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_join.setOnClickListener{
            val joinIntent = Intent(this,Join_Activity::class.java)
            startActivityForResult(joinIntent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
        {
            when(requestCode){
             100 ->{
                 val id = data!!.getStringExtra("user_id").toString()
                 Log.d("main id",id)
                 et_id.text = Editable.Factory.getInstance().newEditable(id)
                 val pw = data!!.getStringExtra("user_pw").toString()
                 Log.d("main pw",pw)
                 et_pw.text = Editable.Factory.getInstance().newEditable(pw)
             }
            }
        }
    }
}
