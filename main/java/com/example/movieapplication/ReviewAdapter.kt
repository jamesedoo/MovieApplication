package com.example.movieapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter (private val movieList: List<Movie>): RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int)=
        ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_review, viewGroup, false))

    override fun onBindViewHolder(viewHolder: ReviewAdapter.ViewHolder, position: Int) {
        viewHolder.tvItem.text= movieList[position].movieName
        viewHolder.ivItem.setImageResource(movieList[position].movieImg)


    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    override fun getItemCount(): Int { return movieList.size }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem: TextView=view.findViewById(R.id.idTVCourse)
        val ivItem: ImageView =view.findViewById(R.id.idIVCourse)
    }
}