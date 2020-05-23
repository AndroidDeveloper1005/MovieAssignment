package com.example.movieassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieassignment.R
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.Crew

class MovieCrewAdapter(val viewModel: BaseViewModel? =null) : RecyclerView.Adapter<MovieCreditViewHolder>(){

    private var movieCrewDataList : List<Crew> ? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCreditViewHolder {
        return MovieCreditViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.movie_credit_item,
            parent,
            false))
    }

    override fun getItemCount(): Int {
        return movieCrewDataList?.size?:0
    }

    override fun onBindViewHolder(holder: MovieCreditViewHolder, position: Int) {
        if (!movieCrewDataList.isNullOrEmpty()){
            holder.update(movieCrewDataList?.get(position)!!)
        }
    }

    fun setMovieCrewData(movieCrewList : List<Crew>){
        this.movieCrewDataList = movieCrewList
        notifyDataSetChanged()
    }

}
