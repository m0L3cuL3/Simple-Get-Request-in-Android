package com.example.android.apiapp.api

import com.example.android.apiapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")

    suspend fun getPost(): Response<Post>

}