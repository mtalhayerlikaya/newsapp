package com.example.projecttolearn.service

import com.example.projecttolearn.model.Article
import com.example.projecttolearn.model.News
import com.example.projecttolearn.model.Outer
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface newsAPI {



    //GENERAL BASE_URL = ""
    // v2/top-headlines?language=en&category=business&apiKey=561bead551714dfb8ed606d3a312eedb

    @GET("v2/top-headlines")
     fun getNews(
        @Query("language") language:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String

    ): Single<Outer>

}