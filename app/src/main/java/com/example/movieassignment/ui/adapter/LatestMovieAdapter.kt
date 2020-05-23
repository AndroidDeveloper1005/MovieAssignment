package com.example.movieassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieassignment.R
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.Movie

class LatestMovieAdapter(val viewModel : BaseViewModel ? = null): RecyclerView.Adapter<LatestMovieViewHolder>() {

    private var latestMovieData : List<Movie> ? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestMovieViewHolder {
        return LatestMovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.latest_movie_item,
            parent,
            false), viewModel)
    }

    override fun getItemCount(): Int {
        return latestMovieData?.size?:0
    }

    override fun onBindViewHolder(holder: LatestMovieViewHolder, position: Int) {
        if (!latestMovieData.isNullOrEmpty()) {
            holder.update(latestMovieData?.get(position)!!)
        }
    }

    fun setLatestMovieData(latestMovieData : List<Movie>){
        this.latestMovieData = latestMovieData
        notifyDataSetChanged()
    }

}