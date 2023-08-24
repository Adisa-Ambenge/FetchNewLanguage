package com.angela.mylanguage.API

import com.angela.mylanguage.Model.LanguageData
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getPosts():Response<List<LanguageData>>
}


