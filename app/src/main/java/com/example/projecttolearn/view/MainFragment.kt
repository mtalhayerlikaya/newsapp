package com.example.projecttolearn.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.Debug.waitForDebugger
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttolearn.R
import com.example.projecttolearn.model.Article
import com.example.projecttolearn.viewmodel.MainViewModel
import io.reactivex.Observer
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

      //   lateinit var arrayList: ArrayList<News>
       lateinit var  mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.loadDataFromAPI("en","business", "561bead551714dfb8ed606d3a312eedb")


        card_recycler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val cardViewAdapter=CardViewAdapter()
        card_recycler.adapter = cardViewAdapter

        topbar_recycler_view.layoutManager =  LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val topbarRecyclerView=TopbarRecyclerAdapter()
        topbar_recycler_view.adapter = topbarRecyclerView

        recent_news_main_recycler_view.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val recentNewsRecycler=RecentNewsAdapter()
        recent_news_main_recycler_view.adapter = recentNewsRecycler



        observeLiveData()
    }


    private fun observeLiveData(){

        mainViewModel.news.observe(viewLifecycleOwner,{news->

            var arrayList = ArrayList<Article>()



    })


    }




}
