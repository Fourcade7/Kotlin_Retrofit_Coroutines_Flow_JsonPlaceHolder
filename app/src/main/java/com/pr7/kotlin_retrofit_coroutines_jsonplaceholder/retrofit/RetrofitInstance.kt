package com.pr7.kotlin_retrofit_coroutines_jsonplaceholder

import com.pr7.kotlin_retrofit_coroutines_jsonplaceholder.retrofit.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api= retrofit.create(Api::class.java)
}