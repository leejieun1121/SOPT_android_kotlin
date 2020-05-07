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