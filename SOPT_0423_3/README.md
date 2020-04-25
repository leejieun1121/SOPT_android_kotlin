첫째주 세미나 과제#4 :books:

SharedPreferences 사용해서 자동로그인 기능 구현하기

먼저 LoginActivity 를 만들어준다.

<img width="308" alt="스크린샷 2020-04-25 오후 4 14 17" src="https://user-images.githubusercontent.com/53978090/80274136-30bc5a00-8713-11ea-8cbc-3b34938c76fc.png">

**Activity_login.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="180dp"
        android:layout_height="80dp"

        android:layout_marginTop="128dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:background="@drawable/sopt_logo"
        />

    <EditText
        android:id="@+id/et_id"
        android:layout_width="0dp"
        android:layout_height="40dp"
        android:background="@drawable/et_background"
        android:layout_marginStart="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="52dp"
        android:layout_marginEnd="24dp"
        android:layout_marginRight="24dp"
        android:paddingLeft="20dp"
        android:ems="10"
        android:inputType="text"
        android:hint="아이디"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView2" />

    <EditText
        android:id="@+id/et_pw"
        android:layout_width="0dp"
        android:layout_height="40dp"
        android:layout_marginTop="24dp"
        android:inputType="textPassword"
        android:ems="10"
        android:paddingLeft="20dp"
        android:background="@drawable/et_background"
        android:hint="비밀번호"
        app:layout_constraintEnd_toEndOf="@+id/et_id"
        app:layout_constraintStart_toStartOf="@+id/et_id"
        app:layout_constraintTop_toBottomOf="@+id/et_id" />

    <Button
        android:id="@+id/btn_login"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:background="@drawable/btn_background"
        android:textColor="#fff"
        android:text="로그인"
        app:layout_constraintEnd_toEndOf="@+id/et_pw"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="@+id/et_pw"
        app:layout_constraintTop_toBottomOf="@+id/et_pw" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        android:text="아직 회원이 아니신가요?"
        app:layout_constraintEnd_toStartOf="@+id/tv_join"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintHorizontal_chainStyle="packed"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btn_login" />

    <TextView
        android:id="@+id/tv_join"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:text="회원 가입"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/textView3"
        app:layout_constraintTop_toBottomOf="@+id/btn_login" />

</androidx.constraintlayout.widget.ConstraintLayout>

~~~

여기서 회원가입 버튼을 누르면 회원가입 액티비티로 넘어간다

<img width="308" alt="스크린샷 2020-04-25 오후 4 09 21" src="https://user-images.githubusercontent.com/53978090/80274141-37e36800-8713-11ea-9bf4-68ec77856837.png">

**Activity_join.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity"
    android:paddingHorizontal="30dp"
    android:layout_gravity="center">

    <ImageView
        android:layout_marginTop="100dp"
        android:layout_width="180dp"
        android:layout_gravity="center_horizontal"
        android:layout_height="80dp"
        android:background="@drawable/sopt_logo" />
    <TextView
        android:layout_width="wrap_content"
        android:layout_marginTop="10dp"
        android:inputType="text"
        android:layout_gravity="center_horizontal"
        android:text="회원가입"
        android:textSize="24sp"
        android:layout_marginBottom="40dp"
        android:layout_height="wrap_content"/>
    <EditText
        android:id="@+id/et_email"
        android:layout_marginVertical="10dp"
        android:hint="이메일"
        android:paddingLeft="20dp"
        android:inputType="text"
        android:background="@drawable/et_background"
        android:layout_width="match_parent"
        android:layout_height="40dp"/>
    <EditText
        android:id="@+id/et_pw"
        android:layout_marginVertical="10dp"
        android:hint="비밀번호"
        android:paddingLeft="20dp"
        android:inputType="text"
        android:background="@drawable/et_background"
        android:layout_width="match_parent"
        android:layout_height="40dp"/>
    <EditText
        android:id="@+id/et_pwcheck"
        android:layout_marginVertical="10dp"
        android:hint="비밀번호 확인"
        android:paddingLeft="20dp"
        android:inputType="text"
        android:background="@drawable/et_background"
        android:layout_width="match_parent"
        android:layout_height="40dp"/>
    <EditText
        android:id="@+id/et_git_nick"
        android:background="@drawable/et_background"
        android:layout_marginVertical="10dp"
        android:hint="Github 닉네임"
        android:paddingLeft="20dp"
        android:inputType="text"
        android:layout_width="match_parent"
        android:layout_height="40dp"/>
    <Button
        android:id="@+id/et_join"
        android:background="@drawable/btn_background"
        android:layout_marginTop="20dp"
        android:text="가입완료"
        android:textColor="#fff"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>



</LinearLayout>

~~~

만들어준 로그인 레이아웃에 이메일과 패스워드 , 깃닉네임을 입력해주고

가입완료 버튼을 누르면 put.Extra로 아이디와 패스워드를 로그인액티비티로 넘겨준다

~~~
et_join.setOnClickListener {
            val loginIntent = Intent()
            loginIntent.putExtra("user_id", et_email.text.toString())
            loginIntent.putExtra("user_pw", et_pw.text.toString())
            //Log.d("join id",id)
            //Log.d("join pw",pw)
            setResult(Activity.RESULT_OK,loginIntent)
            finish()
        }
~~~

넘겨받은 아이디와 비밀번호를 저장해서 자동로그인을 할 수 있도록 하려면 여러가지 방법이 있지만 간단하게 구현하려면 SharedPreferences 를 사용하면 된다.

- SharedPreferences

  : App에 포함되는 데이터 파일을 만들어 (key,value)형태로 디바이스에 저장/로드하는 방법이다. editor()를 사용해서 데이터의 수정,삭제도 가능하다.

먼저 SharedPreferences Class를 생성해준다.

**MySharedPreferences.kt**
~~~
package com.example.sopt_0423_3

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences (context: Context) {
    //아이디,비밀번호가 저장될 파일 이름
    val PREFS_FILENAME = "users"  
    //아이디와 비밀번호값을 저장해줄거기 때문에 myid, mypw변수 생성
    val PREF_KEY_ID = "myid"
    val PREF_KEY_PW = "mypw"
    val users:SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,0)

//get,set함수를 설정해준다.
    var myid: String
    get() = users.getString(PREF_KEY_ID,"")!!
    set(value) = users.edit().putString(PREF_KEY_ID,value).apply()

    var mypw: String
    get() = users.getString(PREF_KEY_PW,"")!!
    set(value) = users.edit().putString(PREF_KEY_PW,value).apply()
}
~~~

그다음 AppClass를 생성하여 SharedPreferences를 먼저 쓸 수 있도록 설정한다.

**App.kt**

~~~
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
~~~

마지막으로 manifest에 App Class의 이름을 등록해주면 된다.

**AndroidManifest.xml**

~~~
<aplication 
	android:name =".App"
	...
</aplication>
~~~

그다음 LoginActivity에서 사용해주면 된다.

**LoginActivity.kt**

~~~
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
~~~



<img width="308" alt="스크린샷 2020-04-25 오후 4 09 47" src="https://user-images.githubusercontent.com/53978090/80274149-46318400-8713-11ea-87a7-d794302e8707.png">

회원가입 버튼을 누르면 edit text에 입력했던 아이디와 비밀번호가 자동으로 입력되고

(나는 미리 정해둔 아이디와 비밀번호가 아니라면 MainActivity로 넘어가지 않도록 했다.)

<img width="308" alt="스크린샷 2020-04-25 오후 4 10 21" src="https://user-images.githubusercontent.com/53978090/80274153-4b8ece80-8713-11ea-950d-1ddb876b32a5.png">


앱을 종료하고 다시 켜도 남아있다 ㅎ

<img width="308" alt="스크린샷 2020-04-25 오후 4 09 47" src="https://user-images.githubusercontent.com/53978090/80274155-5184af80-8713-11ea-82b9-dcc803e5adf0.png">

자동로그인 기능 구현 완료 ~~ :clap: :clap:
