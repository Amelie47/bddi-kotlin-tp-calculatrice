package com.gmail.ameliemouillacpro.news.repositories

import android.os.Build
import com.gmail.ameliemouillacpro.news.BuildConfig
import com.gmail.ameliemouillacpro.news.services.ArticleService
import com.gmail.ameliemouillacpro.recyclerview.models.Article
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

class Articlepository {
    private val service: ArticleService

    private val requestInterceptor: Interceptor = Interceptor { chain ->
        val original: Request = chain.request()

        val url: HttpUrl = original.url
            .newBuilder()
            .addQueryParameter("ApiKey", "11babd4c0a654f0b99bd02c3927baa09")
            .build()

        val device = Build.MANUFACTURER + "-" + Build.MODEL

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .addHeader("User-Agent", "Android-${BuildConfig.VERSION_CODE}-($device)")
            .addHeader("Accept-Language", Locale.getDefault().language)
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .url(url)

        val request = requestBuilder.build()
        return@Interceptor chain.proceed(request)
    }

    init {
        // Créer un client http
        val client = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()

        // Instance retrofit avec url commune de l'api
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        }.addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(client)
            .build()

        // Instance du service
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(keyword:String): List<Article> {
        val response = service.list(keyword).execute()

        // Le body peut être nul, alors on anticipe
        return response.body()?.articles ?: emptyList()
    }
}