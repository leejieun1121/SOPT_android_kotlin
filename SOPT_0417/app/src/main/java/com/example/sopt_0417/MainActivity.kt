package com.example.sopt_0417

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_main.setOnClickListener {
            var text = "코틀린으로 넘어오니까 바보가 된 기분이다ㅎㅎ"
            tv_main.setText(text)
            Toast.makeText(this,"완료!",Toast.LENGTH_SHORT).show()
        }


    }
}
