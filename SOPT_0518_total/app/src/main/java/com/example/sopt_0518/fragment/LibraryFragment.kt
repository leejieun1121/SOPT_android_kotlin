package com.example.sopt_0518.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sopt_0518.R
import com.example.sopt_0518.data.BookData
import com.example.sopt_0518.data.ResponseBook
import com.example.sopt_0518.network.RequestToServer1
import kotlinx.android.synthetic.main.fragment_library.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LibraryFragment : Fragment() {
    val requestToServer1 = RequestToServer1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_search.setOnClickListener {
            Log.e("클릭 실행","클릭 실행")
            requestToServer1.service.requestSearchBook(
                BookData(
                    title = et_search.text.toString()
                )
            ).enqueue(object : Callback<ResponseBook>{
                override fun onFailure(call: Call<ResponseBook>, t: Throwable) {
                    Toast.makeText(context,"가져오기 실패",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ResponseBook>,
                    response: Response<ResponseBook>
                ) {
                    if(response.isSuccessful){
                        Log.d("Book",response.body().toString())

                    }
                }

            })
        }

    }

    
}
