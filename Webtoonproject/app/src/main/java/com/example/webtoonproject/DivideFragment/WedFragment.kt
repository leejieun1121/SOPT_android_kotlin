package com.example.webtoonproject.DivideFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.webtoonproject.R
import com.example.webtoonproject.WebRecycler.Webtoondata
import com.example.webtoonproject.WebRecycler.WedWebtoonAdapter
import kotlinx.android.synthetic.main.fragment_wed.*

/**
 * A simple [Fragment] subclass.
 */
class WedFragment : Fragment() {

    lateinit var WedWebtoonAdapter : WedWebtoonAdapter
    val datas : MutableList<Webtoondata> = mutableListOf<Webtoondata>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wed, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WedWebtoonAdapter = WedWebtoonAdapter(view.context)
        rv_wed.adapter = WedWebtoonAdapter
        loadDatas()


    }

    private fun loadDatas(){
        datas.apply {
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/626907/thumbnail/title_thumbnail_20150407141027_t83x90.jpg",
                    web_name = "복학왕",
                    rate = "9.93",
                    writer = "기안84"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/728015/thumbnail/thumbnail_IMAG10_97de566e-d2cd-4590-b071-c678a3e85c56.jpg",
                    web_name = "모죠의 일지",
                    rate = "9.93",
                    writer = "모죠"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/662774/thumbnail/thumbnail_IMAG10_fddc4c8b-fbe6-422c-9777-590d98f4dc9e.jpg",
                    web_name = "고수",
                    rate = "9.93",
                    writer = "연놈"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
            add(
                Webtoondata(
                    img_data = "https://shared-comic.pstatic.net/thumb/webtoon/730174/thumbnail/thumbnail_IMAG04_6ed54bb7-5919-4280-afdf-cae2f4d76e3d.jpg",
                    web_name = "유미의 세포들",
                    rate = "9.93",
                    writer = "이동건"
                )
            )
                WedWebtoonAdapter.datas = datas
                WedWebtoonAdapter.notifyDataSetChanged()
        }
    }

}
