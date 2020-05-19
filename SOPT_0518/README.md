### Retrofit2 이용해서 로그인 API 써보기

먼저 라이브러리를 추가해줍니다.

**build.gradle(Module:app)**

~~~
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'
    implementation 'com.google.code.gson:gson:2.8.6'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'
~~~

<img width="308" alt="스크린샷 2020-05-19 오전 1 06 00" src="https://user-images.githubusercontent.com/53978090/82239277-7c110380-9973-11ea-8b8f-4c7c05b896be.png">


로그인 화면에서 넘겨줄 데이터는 아이디와 비밀번호 (즉, Request객체) 그리고 받을 데이터는 성공여부 (Response객체 이므로 클래스를 만들어준다)


<img width="370" alt="스크린샷 2020-05-19 오전 1 09 19" src="https://user-images.githubusercontent.com/53978090/82239287-829f7b00-9973-11ea-8cc2-755c162c5c94.png">


**RequestLogin.kt**

~~~
data class RequestLogin(
    val id : String,
    val password : String
)
~~~



<img width="753" alt="스크린샷 2020-05-19 오전 1 09 38" src="https://user-images.githubusercontent.com/53978090/82239301-87fcc580-9973-11ea-92a7-9a8bd25677d0.png">

**ResponseLogin.kt**

~~~
data class ResponseLogin(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : SomeData?
//    @SerializedName("data")
//    //서버에서 정한 변수 말고 직접 이름을 지을수도 있음
//    val responseData : SomeData?
)

data class SomeData(
    val jwt : String
)
~~~


<img width="292" alt="스크린샷 2020-05-19 오전 1 12 17" src="https://user-images.githubusercontent.com/53978090/82239319-8d5a1000-9973-11ea-9c18-317b6b425cc9.png">

그리고 API를 보고 Retrofit Interface를 설계해준다.

**RequestInterface**

~~~
interface  RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>
}
~~~

그 다음 만들어둔 인터페이스를 구현하는 구현체를 만들어준다.

**RequestToServer**

~~~
//object : 싱글톤 선언, 아무데서나 접근 가능하지만 객체는 하나만 생성되어 공유
object RequestToServer{
    var retrofit = Retrofit.Builder()
        .baseUrl("http://13.209.144.115:3333")
        .addConverterFactory(GsonConverterFactory.create()) //json데이터를 데이터 클래스로 변환 쉽게 해줌
        .build()

    //retrofit 객체 create 호출 , interface 클래스 타입을 넘겨 실제 구현체를 만들어줌
    var service : RequestInterface = retrofit.create(RequestInterface::class.java)

}
~~~

이제 로그인 화면에서 로그인 버튼을 눌렀을때 만들어둔 구현체를 사용하여 callback을 등록해서 통신하면 된다.

**LoginActivity.kt**

~~~~
class LoginActivity : AppCompatActivity() {
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn_login.setOnClickListener{
            if(et_id.text.isNullOrBlank() || et_pw.text.isNullOrBlank()){
                Toast.makeText(this@LoginActivity,"아이디와 패스워드가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
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
                        if(response.isSuccessful){ //status 상태코드 200-300
                            Log.d("response",response.toString());
                            if(response.body()!!.success){ //아이디 패스워드 일치할 때
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
~~~~

<img width="309" alt="스크린샷 2020-05-19 오전 1 31 44" src="https://user-images.githubusercontent.com/53978090/82239354-9cd95900-9973-11ea-98f2-a1a91c38c4d7.png">

일치하지 않는 아이디와 비밀번호를 입력했을때의 로그를 찍어보았다.

<img width="1133" alt="스크린샷 2020-05-19 오전 1 32 15" src="https://user-images.githubusercontent.com/53978090/82239371-a5319400-9973-11ea-9385-6135dcd30bfb.png">

<img width="311" alt="스크린샷 2020-05-19 오전 1 33 11" src="https://user-images.githubusercontent.com/53978090/82239407-aebafc00-9973-11ea-9196-41727426f396.png">

<img width="311" alt="스크린샷 2020-05-19 오전 1 33 42" src="https://user-images.githubusercontent.com/53978090/82239434-b67aa080-9973-11ea-9dce-36b70217ca47.png">

일치하는 아이디와 비밀번호를 입력하면 메인화면으로 넘어가는걸 확인할 수 있다.

<img width="1364" alt="스크린샷 2020-05-19 오전 1 34 08" src="https://user-images.githubusercontent.com/53978090/82239457-bbd7eb00-9973-11ea-9f22-b42368b932c9.png">
