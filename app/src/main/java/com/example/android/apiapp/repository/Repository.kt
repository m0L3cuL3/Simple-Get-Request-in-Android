package com.example.android.apiapp.repository

import com.example.android.apiapp.api.RetrofitInstance
import com.example.android.apiapp.model.Post
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

}