package com.example.projecttolearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttolearn.R
import kotlinx.android.synthetic.main.news_recycler_card_item.view.*
import kotlinx.android.synthetic.main.recent_news_recyclerview_item.view.*

class RecentNewsAdapter : RecyclerView.Adapter<RecentNewsAdapter.RecentNewsHolder>() {
    class RecentNewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentNewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recent_news_recyclerview_item,parent,false)
        return RecentNewsHolder(view)
    }

    override fun onBindViewHolder(holder: RecentNewsHolder, position: Int) {
        holder.itemView.recent_news_image_view.setImageResource(R.drawable.ic_launcher_background)
        holder.itemView.recent_news_writer_name.text = "Talha Yerlikaya"
        holder.itemView.recent_news_article_name.text = "Global Warming"
        holder.itemView.recent_news_cardview.setOnClickListener(View.OnClickListener {view->
            val directions = MainFragmentDirections.actionMainFragmentToDetailFragment()
            Navigation.findNavController(view).navigate(directions)
        })


    }

    override fun getItemCount(): Int {

        return 10

    }
}