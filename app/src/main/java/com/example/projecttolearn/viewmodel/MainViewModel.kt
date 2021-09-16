package com.example.projecttolearn.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projecttolearn.model.Article
import com.example.projecttolearn.model.Outer
import com.example.projecttolearn.service.NewsService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Job

//arraylist iste
class MainViewModel() : ViewModel() {

    val viewModelJob = Job()
    var compositeDisposable = CompositeDisposable()
    var newsService = NewsService()

    var news = MutableLiveData<List<Article>>()
    var news_author = MutableLiveData<String>()
    var news_date = MutableLiveData<String>()
    var news_title = MutableLiveData<String>()
    var news_content = MutableLiveData<String>()
    var news_image_url = MutableLiveData<String>()


    fun refreshData(language:String, category:String, apiKey:String){
        loadDataFromAPI(language, category, apiKey)
    }

    fun loadDataFromAPI(language:String, category:String, apiKey:String){

            //viewModelScope.launch(Dispatchers.IO) {

                compositeDisposable.add(
                    newsService.getData(language, category, apiKey)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribeWith(object : DisposableSingleObserver<Outer>() {
                            override fun onSuccess(t: Outer) {

                                t.getData()?.let {article->

                                    news.value = article

                                }

                            }

                            override fun onError(e: Throwable) {
                                e.printStackTrace()
                            }

                        }

                        )
                )
          //  }
    }





}


