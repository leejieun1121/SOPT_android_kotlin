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
        //rv_home.addItemDecoration(InstaItemDecoration(view.context))
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