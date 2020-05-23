package com.example.movieassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieassignment.R
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.Cast

class MovieCastAdapter(val viewModel : BaseViewModel? =null) : RecyclerView.Adapter<MovieCreditViewHolder>(){

    private var movieCastList : List<Cast> ? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCreditViewHolder {
        return MovieCreditViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.movie_credit_item,
            parent,
            false), viewModel)
    }

    override fun getItemCount(): Int {
        return movieCastList?.size?:0
    }

    override fun onBindViewHolder(holder: MovieCreditViewHolder, position: Int) {
        if (!movieCastList.isNullOrEmpty()){
            holder.update(movieCastList?.get(position)!!)
        }
    }

    fun setMovieCastData(movieCastList : List<Cast>){
        this.movieCastList = movieCastList
        notifyDataSetChanged()
    }


}