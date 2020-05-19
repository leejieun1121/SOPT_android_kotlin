package com.example.sopt_0518

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sopt_0518.data.RequestLogin
import com.example.sopt_0518.data.ResponseLogin
import com.example.sopt_0518.network.RequestToServer

import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_login.setOnClickListener{
            if(et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()){
                Toast.makeText(this@LoginActivity,"아이디와 패스워드 전부 입력해주세요.",Toast.LENGTH_LONG).show()
            }else {
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_pw.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        if(response.isSuccessful){
                            Log.d("response",response.toString())
                            if(response.body()!!.success){
                                Log.d("response_body",response.body().toString())
                                Toast.makeText(this@LoginActivity,"로그인 성공",Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@LoginActivity,MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Log.d("response_body",response.body().toString())
                                Toast.makeText(this@LoginActivity,"아이디 비밀번호를 확인하세요",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                })

            }
        }

        tv_join.setOnClickListener{
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }

    }
}