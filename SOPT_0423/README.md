### 첫째주 세미나과제 #1 :blue_book:

ConstraintLayout 심화학습

- ConstraintDimentionRatio 이용해서 1:1 비율로 이미지 삽입
- Guideline 이용해보기

<img width="310" alt="스크린샷 2020-04-24 오전 1 49 26" src="https://user-images.githubusercontent.com/53978090/80129749-7a515b80-85d2-11ea-8d66-f1a000c7fe12.png">
'''

```
<ImageView
    android:id="@+id/imgview_food"
    android:layout_width="0dp"
    android:layout_height="0dp"
    android:layout_marginTop="20dp"
    android:src="@drawable/chicken"
    app:layout_constraintDimensionRatio="1:1"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"></ImageView>
```

'''

**app:layout_constraintDimensionRatio**

: 수평 수직의 비율로 크기를 정할때 사용 (width : height)

위의 사진에서는 1:1을 줬기 때문에 수평 수직이 1:1로 들어간걸 볼 수 있다.



**Guideline**

: ConstraintLayout의 제약조건을 쉽게 설정하도록 도와주는 헬퍼클래스,

화면에 직접 나타나진않고 오로지 ConstraintLayout을 위해 사용된다

수직 - width=0, height=ConstraintLayout과 같다

수평 - height=0, width=ConstraintLayout과 같다

- Layout_constraintGuide_begin : left나 top에서부터 고정~
- Layout_constraintGuide_end : right나 bottom 에서부터 고정 ~
- 


<img width="285" alt="스크린샷 2020-04-24 오전 1 59 11" src="https://user-images.githubusercontent.com/53978090/80129761-7e7d7900-85d2-11ea-9351-78b9945dd9d9.png">

'''

```
<TextView
    android:id="@+id/tv_info"
    android:layout_marginVertical="10dp"
    android:layout_width="0dp"
    android:layout_marginLeft="10dp"
    android:layout_height="wrap_content"
    android:text="1.치킨전메뉴 100% 국내산 2.치킨주문시 콜라별도입니다. 3.다양한 사이드메뉴 주문 가"
    app:layout_constraintEnd_toStartOf="@+id/guidline"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/tv_store"></TextView>

<androidx.constraintlayout.widget.Guideline
    android:id="@+id/guidline"
    android:layout_width="1dp"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    app:layout_constraintGuide_percent="0.8"
    ></androidx.constraintlayout.widget.Guideline>
```

'''

구현해야하는 과제가 right에서 떨어져있는 모양이였기 때문에 vertical로 주고 

layout_constraintGuide_percent로 width의 80퍼센트 위치에 가이드라인을 줬다 
