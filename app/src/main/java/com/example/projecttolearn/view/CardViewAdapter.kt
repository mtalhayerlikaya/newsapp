package com.example.projecttolearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttolearn.R
import kotlinx.android.synthetic.main.news_recycler_card_item.view.*
//arraylist iste
class CardViewAdapter() : RecyclerView.Adapter<CardViewAdapter.PhoneViewHold?>() {

    class PhoneViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewAdapter.PhoneViewHold {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_recycler_card_item,parent,false)

        return PhoneViewHold(view)
    }

    override fun onBindViewHolder(holder: CardViewAdapter.PhoneViewHold, position: Int) {

    holder.itemView.cardview_article_header_text.text = "Global Warming"
    holder.itemView.cardview_writer_name_text.text = "Talha Yerlikaya"
    holder.itemView.cardview_news_image.setImageResource(R.drawable.ic_launcher_background)
    holder.itemView.cardview.setOnClickListener(View.OnClickListener {view->
        val directions = MainFragmentDirections.actionMainFragmentToDetailFragment()
        Navigation.findNavController(view).navigate(directions)
    })
    }

    override fun getItemCount(): Int {
        //return newsList.size
        return 5
    }

}