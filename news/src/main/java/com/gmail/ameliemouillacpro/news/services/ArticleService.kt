package com.gmail.ameliemouillacpro.news.services

import com.gmail.ameliemouillacpro.recyclerview.models.ArticleResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("everything")
    fun list(@Query("q") query: String): Call<ArticleResult>
}