package com.example.movieassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieassignment.R
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.Cast
import com.example.movieassignment.model.SimilarMovieItem
import com.example.movieassignment.ui.movie_detail.MovieDetailViewModel

class SimilarMovieAdapter(val viewModel : BaseViewModel?=null): RecyclerView.Adapter<MovieCreditViewHolder>(){

    private var similarMoviesList : List<SimilarMovieItem> ? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCreditViewHolder {
        return MovieCreditViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
            R.layout.movie_credit_item,
            parent,
            false), viewModel)
    }

    override fun getItemCount(): Int {
        return similarMoviesList?.size?:0
    }

    override fun onBindViewHolder(holder: MovieCreditViewHolder, position: Int) {
        if (!similarMoviesList.isNullOrEmpty()){
            holder.update(similarMoviesList?.get(position)!!)
        }
    }

    fun setSimilarMoviesData(similarMoviesList : List<SimilarMovieItem>){
        this.similarMoviesList = similarMoviesList
        notifyDataSetChanged()
    }
}
