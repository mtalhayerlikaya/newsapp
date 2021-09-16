package com.example.projecttolearn.service

import com.example.projecttolearn.model.Article
import com.example.projecttolearn.model.Outer
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsService {

    final val BASE_URL = "https://newsapi.org/"


    var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(newsAPI::class.java)


     fun getData(language:String, category:String, apiKey:String): Single<Outer> {
        return retrofit.getNews(language, category, apiKey)
    }
    
}