<img width="311" alt="스크린샷 2020-06-12 오후 9 06 59" src="https://user-images.githubusercontent.com/53978090/84501400-6df3a000-acf1-11ea-8ffb-6d190297e3cb.png">

BottomNavigationView와 RecyclerView를 이용해서 만든 웹툰페이지입니다!

**fragment_wed.xml**


~~~
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".DivideFragment.WedFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_wed"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:spanCount="3"
        tools:listitem="@layout/webtoon_item"
        />

</FrameLayout>
~~~

SpanCount에 값을 줘서 한 행에 몇개의 열을 넣을지 결정 !
