첫번째 세미나과제 #2

회원가입 및 로그인 기능 구현하기

먼저 constraintLayout으로 로그인화면을 구현해준다.

<img width="307" alt="스크린샷 2020-04-24 오전 2 32 15" src="https://user-images.githubusercontent.com/53978090/80132694-04032800-85d7-11ea-90f9-45c5829b68eb.png">

그리고 회원가입 화면은 LinearLayout으로 만들어줬다


<img width="307" alt="스크린샷 2020-04-24 오전 2 33 53" src="https://user-images.githubusercontent.com/53978090/80132706-0796af00-85d7-11ea-947d-2e34b15017da.png">

레이아웃은 이렇게 만들어 주고

인텐트로 넘긴 값을 받아오는게 과제였기때문에 startActivityForResult를 사용해줬다.

startActivityForResult

startActivity는 단순히 다른 activity로 넘겨주는 메소드라면 startActivityForResult는 requestCode로 다양한 상황에서 사용할 수 있다. ex) RESULT_OK는 작업성공,RESULT_CANCELED는 작업 실패 

로그인 액티비티에서 회원가입버튼을 누르면 회원가입 액티비티로 넘어가고 거기서 작성한 값을 받아오는거기 때문에, 로그인 액티비티의 회원가입이라는 글자에 이벤트 리스너를 등록하고 startActivityForResult(joinIntent,RequestCode)를 실행!

Login.Activity.kt 

(올린 파일에서는 MainActivity.kt이다ㅠ LoginActivity로 따로 뺐어야했는데 MainActivity에 그냥 작성해버렸다..ㅎ )


tv_join.setOnClickListener{
    val joinIntent = Intent(this,Join_Activity::class.java)
    startActivityForResult(joinIntent, 100)
}

그리고 onActivityrResult메소드를 오버라이드해서 작업이 잘 이뤄졌고(requestCode == Activity.RESULT_OK) , 결과로 받은 requestCode와 startActivityForResult로 넘겨준 RequestCode값이 일치한다면 넘겨받은 값을 아이디와 패스워드에 보여주면 된다.

LoginActivity.kt


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

회원가입 액티비티로 넘어가면 회원가입할때 사용했던 아이디와 패스워드 값을 putExtra("name",value)로 넘겨준다. 그리고 setResult()로 requestCode와 넘겨줄 값을 넣은 intent 를 써준다.

JoinActivity.kt


    et_join.setOnClickListener {
            val loginIntent = Intent()
            loginIntent.putExtra("user_id", et_email.text.toString())
            loginIntent.putExtra("user_pw", et_pw.text.toString())
            //Log.d("join id",id)
            //Log.d("join pw",pw)
            setResult(Activity.RESULT_OK,loginIntent)
            finish()
        }
이렇게 해주면 아까 로그인 창에 써줬던 getExtra로 넘겨준 값의 name과 일치하는 애를 가져와서 사용할 수 있다 !
