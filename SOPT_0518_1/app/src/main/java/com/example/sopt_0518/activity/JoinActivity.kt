package com.example.sopt_0518.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sopt_0518.R
import com.example.sopt_0518.data.RequestJoin
import com.example.sopt_0518.data.ResponseJoin
import com.example.sopt_0518.network.RequestToServer
import kotlinx.android.synthetic.main.activity_join.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JoinActivity : AppCompatActivity() {
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        et_join.setOnClickListener {
            if(et_id.text.isNullOrBlank()||et_pw.text.isNullOrBlank()||et_name.text.isNullOrBlank()||
                    et_email.text.isNullOrBlank()||et_phone.text.isNullOrBlank())
            {
                Toast.makeText(this@JoinActivity,"입력을 확인해주세요",Toast.LENGTH_SHORT).show()
            }else{
                requestToServer.service.requestJoin(
                    RequestJoin(
                        id = et_id.text.toString(),
                        password = et_pw.text.toString(),
                        name = et_name.text.toString(),
                        email = et_email.text.toString(),
                        phone = et_phone.text.toString()
                    )
                ).enqueue(object:Callback<ResponseJoin>{
                    override fun onFailure(call: Call<ResponseJoin>, t: Throwable) {
                        Log.e("onFailure","통신 실패")
                    }

                    override fun onResponse(
                        call: Call<ResponseJoin>,
                        response: Response<ResponseJoin>
                    ) {
                        Log.d("response",response.body().toString())
                        if(response.isSuccessful){
                            if(response.body()!!.success) {
                                Toast.makeText(this@JoinActivity,"회원가입 성공",Toast.LENGTH_SHORT).show()
                                val loginIntent = Intent()
                                loginIntent.putExtra("user_id", et_id.text.toString())
                                loginIntent.putExtra("user_pw", et_pw.text.toString())
                                //Log.d("join id",id)
                                //Log.d("join pw",pw)
                                setResult(Activity.RESULT_OK,loginIntent)
                                finish()

                            }else{
                                Toast.makeText(this@JoinActivity,"회원가입 실패",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })
            }

        }

    }
}