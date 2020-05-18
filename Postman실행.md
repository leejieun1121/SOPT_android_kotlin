

### Postman 실행해보기 !!

먼저 사용하려는 API를 확인 ! BASE URL 과 login, signin 기능이 있다. 

<img width="406" alt="스크린샷 2020-05-18 오후 10 42 45" src="https://user-images.githubusercontent.com/53978090/82232738-f89ee480-9969-11ea-9e20-1cd3bfea370d.png">


/user/signin - 로그인에 들어가보면 어떤 메소드로 어떤 서비스를 요청할것인지 나와있는 설명과 RequestHeader 가 있다.

<img width="498" alt="스크린샷 2020-05-18 오후 10 51 05" src="https://user-images.githubusercontent.com/53978090/82232875-2552fc00-996a-11ea-937a-4dcfb12684c8.png">

postman 을 실행시켜서

<img width="748" alt="스크린샷 2020-05-18 오후 10 59 06" src="https://user-images.githubusercontent.com/53978090/82232902-300d9100-996a-11ea-9368-001bf0ce7ef9.png">

위의 login API에 나와있는 정보를 써준다. POST방식, baseurl, RequestHeader 

<img width="748" alt="스크린샷 2020-05-18 오후 10 53 47" src="https://user-images.githubusercontent.com/53978090/82232821-12d8c280-996a-11ea-93a0-f6c4dfa9be4d.png">

로그인으로 넘겨줄 값이 id와 password기 때문에, Body 부분에 고대로 써준다 ! 그리고 Send 를 해주면 밑에 응답이 뜬다. 

<img width="1098" alt="스크린샷 2020-05-18 오후 10 39 55" src="https://user-images.githubusercontent.com/53978090/82232965-461b5180-996a-11ea-8d0a-b2d9711f1643.png">

아이디와 비밀번호가 gngsn / qwerty 이기 때문에 로그인에 성공한 모습을 볼 수 있다.

<img width="950" alt="스크린샷 2020-05-18 오후 8 47 59" src="https://user-images.githubusercontent.com/53978090/82233006-50d5e680-996a-11ea-84bb-a9654e7eaf5c.png">

밑에는 qwerty1 로 비밀번호를 틀리게 썼기 때문에 응답에 비밀번호가 일치하지 않다는 메세지가 나온것을 확인 할 수 있다. 



