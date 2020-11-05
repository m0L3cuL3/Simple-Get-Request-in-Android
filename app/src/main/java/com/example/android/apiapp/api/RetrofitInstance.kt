package com.example.android.apiapp.api

import com.example.android.apiapp.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api : SimpleApi by lazy() {
        retrofit.create(SimpleApi::class.java)
    }
}