package com.example.sdie3.testapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //서버 주소
        //
        val retrofit = Retrofit.Builder()
                .baseUrl("http://58.145.101.15:3000") //서버주소 바꿔야함
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var server = retrofit.create(server_service::class.java)

        button_get.setOnClickListener {
            server.getRequest("get").enqueue(object: Callback<ResponseDTO> {
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {
                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    text_view.setText("get : "  + response?.body().toString())
                    println("get : " + response?.body().toString())
                }
            })
        }

        button_get_param.setOnClickListener {
            server.getParamRequest("asdf123").enqueue(object: Callback<ResponseDTO> {
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {
                }
                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    text_view.setText("get param : "  + response?.body().toString())
                    println("get param : " + response?.body().toString())
                }
            })
        }

        button_post.setOnClickListener {
            server.postRequest().enqueue(object : Callback<ResponseDTO> {
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {
                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    text_view.setText("post : "  + response?.body().toString())
                    println("post : " + response?.body().toString())
                }
            })
        }
    }
}
