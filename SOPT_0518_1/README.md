### Retrofit2 이용해서  회원가입 API 써보기

기존에 로그인 API 써보기 프로젝트에 회원가입 API 써보기 부분만 추가했습니당 : )


<img width="310" alt="스크린샷 2020-05-19 오후 2 45 59" src="https://user-images.githubusercontent.com/53978090/82331907-b20bc180-9a1f-11ea-9222-72e4dda759a8.png">

먼저 회원가입 UI를 수정해줍니당


<img width="744" alt="스크린샷 2020-05-19 오후 2 40 49" src="https://user-images.githubusercontent.com/53978090/82331921-b637df00-9a1f-11ea-9ef2-cb64c18543f2.png">

그다음 회원가입 API를 보고 요청 객체 클래스를 만들어줍니다

**RequestJoin.kt**

~~~
data class RequestJoin (
    val id : String,
    val password : String,
    val name : String ,
    val email : String,
    val phone : String
)
~~~

<img width="537" alt="스크린샷 2020-05-19 오후 2 42 17" src="https://user-images.githubusercontent.com/53978090/82331934-b9cb6600-9a1f-11ea-8e27-8a9d47242ab3.png">

그리고 응답 객체 클래스도 만들어줍니다

**ResponseJoin.kt**

~~~
data class ResponseJoin(
    val status : Int,
    val success : Boolean,
    val message : String
)
~~~



로그인 API 써보기 부분에서 RequestInterface 와 RequestToServer 부분을 만들어줬기 때문에 필요한 코드를 추가해줍니다.

<img width="311" alt="스크린샷 2020-05-19 오후 2 50 53" src="https://user-images.githubusercontent.com/53978090/82331952-c059dd80-9a1f-11ea-97f0-d52eea265188.png">

**RequestInterface**

~~~
interface  RequestInterface{
    @POST("/user/signin")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/user/signup")
    fun requestJoin(@Body body : RequestJoin) : Call <ResponseJoin>
}
~~~

**RequestToServer**

요건 그대로

~~~
package com.example.sopt_0518.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

마지막으로 JoinActivity 에서 만들어놓은 구현체를 사용하여 통신하면 끝 !

**JoinActivity.kt**

~~~
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
~~~



<img width="311" alt="스크린샷 2020-05-19 오후 2 54 06" src="https://user-images.githubusercontent.com/53978090/82331976-c6e85500-9a1f-11ea-80e6-1e4cfa5433e0.png">

회원가입란에 정보를 입력하고 가입완료버튼을 누르면 가입완료 !

<img width="311" alt="스크린샷 2020-05-19 오후 2 54 27" src="https://user-images.githubusercontent.com/53978090/82331995-ccde3600-9a1f-11ea-9bb9-7087bce9195d.png">

방금 만든 아이디와 패스워드로 로그인버튼을 누르면

<img width="311" alt="스크린샷 2020-05-19 오후 2 54 30" src="https://user-images.githubusercontent.com/53978090/82332007-d23b8080-9a1f-11ea-9a8d-0ef0d1d0d5b0.png">

잘 성공한다 ㅎㅎ

<img width="311" alt="스크린샷 2020-05-19 오전 1 33 11" src="https://user-images.githubusercontent.com/53978090/82332015-d5cf0780-9a1f-11ea-8ac6-849b837e7dce.png">

응답 로그도 잘 나온다 !

<img width="311" alt="스크린샷 2020-05-19 오후 2 54 30" src="https://user-images.githubusercontent.com/53978090/82332027-d9fb2500-9a1f-11ea-9c64-0a298501fde3.png">

저번에 썼던 아이디와 비밀번호로도 로그인 완료!

![스크린샷 2020-05-19 오후 2.54.30](/Users/oopsla/Desktop/스크린샷 2020-05-19 오후 2.54.30.png)

### r​e​t​ro​f​it​2​ ​써보기 끝 :clap: :clap:
