package com.example.sopt_0423_3

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_id.text = Editable.Factory.getInstance().newEditable(App.users.myid)
        et_pw.text = Editable.Factory.getInstance().newEditable(App.users.mypw)

        tv_join.setOnClickListener{
            val joinIntent = Intent(this,JoinActivity::class.java)
            startActivityForResult(joinIntent, 100)
        }
        btn_login.setOnClickListener{
            if(et_id.text.toString()=="lje4648@naver.com" && et_pw.text.toString()=="1121"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this@LoginActivity,"아이디와 패스워드가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
            }
            if(et_id.text == null || et_pw.text ==null)
                Toast.makeText(this@LoginActivity,"아이디와 패스워드 모두 입력해주세요.",Toast.LENGTH_LONG).show()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
        {
            when(requestCode){
                100 ->{
                    val id = data!!.getStringExtra("user_id").toString()
                    //et_id.text = Editable.Factory.getInstance().newEditable(id)
                    App.users.myid = id
                    et_id.text = Editable.Factory.getInstance().newEditable(App.users.myid)
                    Log.e("id들어오는거 체크",App.users.myid)
                    val pw = data!!.getStringExtra("user_pw").toString()
                    App.users.mypw = pw
                    et_pw.text = Editable.Factory.getInstance().newEditable(App.users.mypw)
                    Log.e("pw들어오는거 체크",App.users.mypw)

                }
            }
        }
    }


}