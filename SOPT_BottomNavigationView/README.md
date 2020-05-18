#### 필수과제 1 #### 

- BottomNavigationView

  : 하단 네비게이션 뷰, 하단의 아이콘을 탭해서 이동할 수 있는 뷰

 커스텀 UI 적용하기

**values -> styles.xml**

~~~
<resources>

    <!-- Base application theme. -->
    <!-- DarkActionBar를 NoActionBar로 바꿔줬다 -> 기존의 상단바 UI를 없애주기 위해-->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
~~~

***values->colors.xml***

에서 색을 이름으로 간단하게 쓰기 위해서 지정해줬음

~~~
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#073392</color>
    <color name="colorPrimaryDark">#08338d</color>
    <color name="colorAccent">#ff0000</color>
    <color name="white">#fff</color>
</resources>
~~~

**activity_main.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.material.appbar.AppBarLayout
        android:id="@+id/appBarLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        >

        <androidx.appcompat.widget.Toolbar
            android:id="@+id/main_toolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorPrimary">

            <!--androidmaxEms : wrapcontent일때, 최대크기설정
            (폰트크기가 바뀌어도, 동일한 텍스트에 대해 텍스트뷰내에서 항상 같은 모양으로 표시) -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="18sp"
                android:textStyle="bold"
                android:text="@string/app_name"
                android:textColor="@color/white"
                android:gravity="center"
                android:maxEms="15" />

        </androidx.appcompat.widget.Toolbar>


    </com.google.android.material.appbar.AppBarLayout>

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/main_viewPager"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintBottom_toTopOf="@+id/bottom_navigationview"
        app:layout_constraintTop_toBottomOf="@+id/appBarLayout" />
    
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigationview"
        android:layout_width="0dp"
        android:layout_height="60dp"
        android:background="@color/colorPrimary"
        app:itemIconTint="@color/bottom_selector"
        app:itemTextColor="@color/bottom_selector"
        app:menu="@menu/navigation"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"></com.google.android.material.bottomnavigation.BottomNavigationView>

 
</androidx.constraintlayout.widget.ConstraintLayout>
~~~

AppbarLayout안에 Toolbar를 사용해서 위의 툴바를 변경해줬다. background 를 아까 colors.xml에 설정해준 색으로 변경, Textview로 툴바에 내용도 써주기

그리고 넘겼을때 바뀌는 화면을 보여주기 위해 ViewPager를 만들어주고

밑에 탭 했을때 화면이 바뀌도록 만들기 위해서 BottomNavigationView를 만들어준다!

home 과 libaray mypage 아이콘이 있는데 이건 menu.xml로 구현해주면 된다.

**res->drawable->menu->navigation.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    xmlns:app="http://schemas.android.com/apk/res-auto"
    <item android:id="@+id/menu_home"
        android:icon="@drawable/ic_home_white"
        android:title="Home"/>
    <item android:id="@+id/menu_book"
        android:icon="@drawable/ic_book_white"
        android:title="Book"/>
    <item android:id="@+id/menu_person"
        android:icon="@drawable/ic_person_white"
        android:title="MyPage"/>
</menu>
~~~



<img width="292" alt="image-20200507224107084" src="https://user-images.githubusercontent.com/53978090/81326660-1e5bfc00-90d5-11ea-9e6a-545603ec9f0d.png">

menu.xml을 만들어주면 이렇게 메뉴가 생기고, ic (아이콘을 만들어 주는 방법은 drawable파일에 vector_asset을 만들어주면 된다.)

**res->drawable->우클릭->new->vector_asset**

<img width="695" alt="image-20200507224349517" src="https://user-images.githubusercontent.com/53978090/81326670-20be5600-90d5-11ea-9e79-a11e8b741e1b.png">

이렇게 안드로이드에서 제공해주는 아이콘으로 다양한 아이콘을 만들어 사용할 수 있다!!

(이걸 몰라서 맨날 아이콘 저장하고 붙여넣어서 사용했는데 아이콘 종류도 되게 많고 좋은거 같다 ㅎㅎ)

이 다음, 바텀네비게이션뷰를 클릭했을때 현재 보이는 페이지의 아이콘은 밝게, 나머지는 어둡게 하는 처리를 해보자

**res->color->bottom_seletor.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="@color/white" android:state_checked="true"/>
    <item android:color="#d9d9d9" android:state_checked="false"/>

</selector>
~~~

이렇게 해주면 체크됐을 때, 체크되지 않았을 때의 구분해서 보여줄 수 있다 !!

만들어준 selector와 menu를 activity_main에 만들어놓은 바텀네비게이션뷰에 적용

<img width="462" alt="image-20200507224824852" src="https://user-images.githubusercontent.com/53978090/81326675-2156ec80-90d5-11ea-938a-2f0ae60527dd.png">

BottomNavigationView의 UI를 다 만들어 주고, 선택되면 각 화면이 바뀌도록 설정해야한다. 액티비티가 아닌 프레그먼트를 사용한다. 

* Fragment

  : 하나의 액티비티 안에서 여러 화면을 구성하기 위해 사용되는 

HomeFragment, LibraryFragment, MyPageFragment를 생성해준다.(자동으로 xml파일도 생성된다)

**HomeFragment.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}
~~~

**fragment_home.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HomeFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="홈 화면 입니다." />

</FrameLayout>
~~~

**LibrayFragment.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

}
~~~

**fragment_library.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".LibraryFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="서재 화면 입니다." />

</FrameLayout>
~~~

**MyPagerFragment.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false)
    }

}
~~~

**fragment_my_page.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MyPageFragment">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="마이페이지 입니다." />

</FrameLayout>
~~~

준비된 프래그먼트와 뷰페이저를 Adapter로 연결해줘야한다.

* Adapter 

  : 보여지는 뷰와 뷰에 나타낼 data를 연결해주는 중간다리 역할 !
 
 
**MainpagerAdapter.kt**

~~~
package com.example.sopt_bottomnavigationview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainpagerAdapter(fm:FragmentManager): FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> HomeFragment() //인덱스 0일때 homefragment
            1-> LibraryFragment()//인덱스 1일때 libraryfragment
            else -> MyPageFragment()//인덱스 2일때 mypagefragkment
        }
    }

    override fun getCount()=3 //프레그먼트의 개수는 3개

}
~~~

어댑터를 만들어주고 어댑터를 등록해준다.

<img width="635" alt="image-20200507230010853" src="https://user-images.githubusercontent.com/53978090/81326679-22881980-90d5-11ea-9ce2-dd6d208a3e9c.png">

이렇게 해주면 viewpager에 잘 반응한다 ! 나머지 만들어둔 bottomnavigationview에도 적용해주면 끝

<img width="591" alt="image-20200507230102494" src="https://user-images.githubusercontent.com/53978090/81326684-2320b000-90d5-11ea-9598-3ef86661ea1b.png">

**MainActivity.kt**

~~~
package com.example.sopt_bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_viewPager.adapter = MainpagerAdapter(supportFragmentManager)
        main_viewPager.offscreenPageLimit = 2
        main_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //네비게이션 메뉴 아이템 체크
                bottom_navigationview.menu.getItem(position).isChecked = true

            }

        })

        bottom_navigationview.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> main_viewPager.currentItem=0
                R.id.menu_book -> main_viewPager.currentItem=1
                R.id.menu_person -> main_viewPager.currentItem=2

            }
        }
    }
}
~~~

<img width="310" alt="스크린샷 2020-05-08 오전 2 52 34" src="https://user-images.githubusercontent.com/53978090/81327953-0c7b5880-90d7-11ea-970c-e563fcdedaed.png">

<img width="308" alt="image-20200507230433857" src="https://user-images.githubusercontent.com/53978090/81326690-23b94680-90d5-11ea-877c-4898e6edf9c1.png">

<img width="308" alt="image-20200507230455635" src="https://user-images.githubusercontent.com/53978090/81326691-2451dd00-90d5-11ea-9750-b9933cbd27df.png">


* RecyclerView 

  : 향상된 listview -> 뷰홀더, 어댑터, 데이터클래스, 리싸이클러뷰 필요

먼저 반복되는 뷰의 아이템 레이아웃을 만들어 줍니당

**item_insta.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/constraintLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:paddingHorizontal="24dp"
        android:paddingVertical="8dp"
        app:layout_constraintTop_toTopOf="parent">

        <de.hdodenhof.circleimageview.CircleImageView
            android:id="@+id/img_profile"
            android:layout_width="48dp"
            android:layout_height="48dp"
            app:srcCompat="@drawable/ic_launcher_background"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/tv_username"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="8dp"
            android:text="TextView"
            android:textColor="@color/white"
            android:textSize="16sp"
            android:textStyle="bold"
            app:layout_constraintBottom_toBottomOf="@+id/img_profile"
            app:layout_constraintStart_toEndOf="@+id/img_profile"
            app:layout_constraintTop_toTopOf="@+id/img_profile" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginEnd="48dp"
            android:layout_marginRight="48dp"
            app:layout_constraintBottom_toBottomOf="@+id/tv_username"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="@+id/tv_username"
            app:layout_constraintVertical_bias="0.563"
            app:srcCompat="@drawable/ic_more_vert_black_24dp" />
    </androidx.constraintlayout.widget.ConstraintLayout>

    <ImageView
        android:id="@+id/img_contents"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:scaleType="centerCrop"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintTop_toBottomOf="@+id/constraintLayout"
        app:srcCompat="@drawable/ic_launcher_background" />

</androidx.constraintlayout.widget.ConstraintLayout>
~~~

프로필(이미지뷰), 이름(텍스트뷰),컨텐츠(이미지뷰)로 구성된 레이아웃!

그리고 이 레이아웃으로 이루어진 아이템이 반복될 방향을 정해준다 

HomeFragment에서 리싸이클러뷰를 사용할거기때문에 fragment_home.xml에 recyclerview를 만들어주면 된다.

**fragment_home.xml**

~~~
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".HomeFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_home"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layoutManager = "androidx.recyclerview.widget.LinearLayoutManager"
        android:orientation="vertical"
        tools:listitem="@layout/item_insta"/>
    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="홈 화면 입니다." />

</FrameLayout>
~~~

그리고 아까 만들어준 레이아웃에 맞는 데이터들을 위해 데이터 클래스 생성!

**InstaData**

~~~
package com.example.sopt_bottomnavigationview

// {}가 아니라 ()
data class InstaData(
    val userName : String,
    val img_profile : String,
    val img_contents : String
)
~~~

그리고 데이터를 뷰로 연결시켜주는 뷰홀더 생성

**InstaViewHolder.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class InstarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tv_username : TextView = itemView.findViewById(R.id.tv_username)
    val img_profile : ImageView = itemView.findViewById(R.id.img_profile)
    val img_contents : ImageView = itemView.findViewById(R.id.img_contents)

    fun bind(instaData: InstaData){
        tv_username.text = instaData.userName;
        Glide.with(itemView).load(instaData.img_profile).into(img_profile)
        Glide.with(itemView).load(instaData.img_contents).into(img_contents)
    }

}
~~~

그리고 뷰홀더와 만들어진 리사이클러뷰를 연결해주는 어댑터 생성

**InstaAdapter.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InstaAdapter (private val context : Context) : RecyclerView.Adapter<InstarViewHolder>(){
    var datas : MutableList<InstaData> = mutableListOf<InstaData>()
    //구현해줘야하는 메소드 3개
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstarViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_insta,parent,false)
        return InstarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size;
    }

    override fun onBindViewHolder(holder: InstarViewHolder, position: Int) {
        holder.bind(datas[position])
    }
}
~~~

그리고 HomeFragment에서 만들어준 어댑터를 사용하여 뷰홀더와 연결해주고, 데이터들을 추가해주면 완성~~

**HomeFragment.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas :MutableList<InstaData> = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()
    }

    private fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                    userName = "이지은",
                    img_profile = "data:image/jpeg;base64,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",
                    img_contents = "https://img.lovepik.com/photo/50027/6182.jpg_wh860.jpg"
                )
            )
            add(
                InstaData(
                    userName = "이지은",
                    img_profile = "data:image/jpeg;base64,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",
                    img_contents = "https://img.lovepik.com/photo/50027/6182.jpg_wh860.jpg"
                )
            )
            add(
                InstaData(
                    userName = "이지은",
                    img_profile = "data:image/jpeg;base64,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",
                    img_contents = "https://img.lovepik.com/photo/50027/6182.jpg_wh860.jpg"
                )
            )
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}

~~~

<img width="308" alt="image-20200508011633877" src="https://user-images.githubusercontent.com/53978090/81326693-2451dd00-90d5-11ea-9273-58050a63c063.png">

#### 필수과제 2 ####

* ItemDecoration 이란

  : 리사이클러뷰에서 아이템 여백을 주는 방법! 



리싸이클러뷰의 레이아웃 매니저를 그리드 레이아웃매니저로 바꿔준다.

<img width="516" alt="image-20200508020704749" src="https://user-images.githubusercontent.com/53978090/81326696-25830a00-90d5-11ea-9b8e-d640b3956276.png">

ItemDecoration 클래스를 생성해준다.

**InstaItemDecoration.kt**

~~~
package com.example.sopt_bottomnavigationview

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class InstaItemDecoration(context: Context) : ItemDecoration() {
    private val size10: Int //10dp 여
    private fun dpTopx(context: Context, dp: Int): Int {
        //코드를 통해 view 사이즈에 변화를 주거나 여백을 설정해줄때는 pixel단위로 변환하여 작업해줘야한다고 함 ! 
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }

    override fun getItemOffsets(//상속
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        //val itemCount = state.itemCount
        //상하 설정
        if (position == 0 || position == 1) { // 첫번 째 줄 아이템
            outRect.top = size10
            outRect.bottom = size10
        } else {
            outRect.bottom = size10
        }

        val lp = view.layoutParams as GridLayoutManager.LayoutParams
        val spanIndex = lp.spanIndex
        if (spanIndex == 0) { //왼쪽 아이템
            outRect.left = size10
            outRect.right = size10
        } else if (spanIndex == 1) { //오른쪽 아이템
            outRect.left = size10
            outRect.right = size10
        }
        outRect.top = size10
        outRect.right = size10
        outRect.bottom = size10
        outRect.left = size10
    }

    init {
        size10 = dpTopx(context, 10)
    }
}
~~~

만들어준 InstaItemDecoration을 리사이클러뷰에 적용시켜주기ㅎ

<img width="517" alt="image-20200508021743578" src="https://user-images.githubusercontent.com/53978090/81326704-261ba080-90d5-11ea-998b-09fa626a1c6e.png">


여백 주기 전

<img width="308" alt="스크린샷 2020-05-08 오전 1 16 18" src="https://user-images.githubusercontent.com/53978090/81326842-60853d80-90d5-11ea-93a0-81c45f3fa1c7.png">

여백 주고 난 후 

<img width="308" alt="스크린샷 2020-05-08 오전 1 59 31" src="https://user-images.githubusercontent.com/53978090/81326934-84e11a00-90d5-11ea-9a15-a73e18ce1216.png">



* clipToPadding 

  :	리사이클러뷰에 패딩을 줄 때, 위 아래의 패딩공간을 사용하여 스크롤할때 공간으로 활용할 수 있는 속성

  clipToPadding = false를 줘야 아이템이 패딩이 있어도 스크롤 할때 가려지지 않기때문에  저걸 써주는게 좋다고 한다 !

  

  **clipToPadding = true일때**

  

<img width="516" alt="스크린샷 2020-05-08 오전 2 13 54" src="https://user-images.githubusercontent.com/53978090/81326946-89a5ce00-90d5-11ea-949a-37331d235be7.png">

<img width="309" alt="스크린샷 2020-05-08 오전 2 15 20" src="https://user-images.githubusercontent.com/53978090/81326948-8a3e6480-90d5-11ea-9311-d0948e8977ed.png">

밑에 패딩때문에 아이템이 가려진다.

하지만 clipToPadding = false를 해주면 패딩이 존재해도 스크롤할 때 아이템을 가리지 않는걸 볼 수 있다.

<img width="517" alt="스크린샷 2020-05-08 오전 2 17 34" src="https://user-images.githubusercontent.com/53978090/81326954-8b6f9180-90d5-11ea-8ccf-03b38374a4e0.png">


<img width="310" alt="스크린샷 2020-05-08 오전 2 18 08" src="https://user-images.githubusercontent.com/53978090/81326960-8c082800-90d5-11ea-855f-6527580cde20.png">

아까와 다르게 패딩이 아이템을 가리지 않는다 !
