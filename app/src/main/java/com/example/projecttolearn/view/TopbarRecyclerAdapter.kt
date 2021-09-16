package com.example.projecttolearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projecttolearn.R
import kotlinx.android.synthetic.main.topbar_recycler_card_item.view.*

class TopbarRecyclerAdapter : RecyclerView.Adapter<TopbarRecyclerAdapter.TopbarViewHolder>() {

    private val topicList = arrayListOf<String>("Business","Entertainment","General","Science","Sports","Technology")

    class TopbarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopbarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topbar_recycler_card_item,parent,false)
        return TopbarViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopbarViewHolder, position: Int) {

        holder.itemView.topbar_recycler_texview.text =topicList.get(position)
        holder.itemView.topbar_cardview.setOnClickListener(View.OnClickListener {

        })

    }

    override fun getItemCount(): Int {
        return 6
    }


}