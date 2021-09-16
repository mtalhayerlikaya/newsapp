package com.example.projecttolearn.model

import com.google.gson.annotations.SerializedName

class Outer {
     @SerializedName("articles")
     var article: List<Article>?=null



     fun getData(): List<Article>? {
          return  article
     }

}