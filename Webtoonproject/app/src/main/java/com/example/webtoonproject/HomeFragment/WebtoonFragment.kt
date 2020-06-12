package com.example.webtoonproject.HomeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.webtoonproject.R
import com.example.webtoonproject.WebtoonAdapter
import kotlinx.android.synthetic.main.fragment_webtoon.*

/**
 * A simple [Fragment] subclass.
 */
class WebtoonFragment : Fragment() {
    lateinit var WebtoonAdapter: WebtoonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webtoon, container, false)
    }
    override fun onStart() {
        super.onStart()

        WebtoonAdapter = WebtoonAdapter(childFragmentManager)
        viewpager_category.adapter = WebtoonAdapter
        tablayout_category.setupWithViewPager(viewpager_category)

    }

}
