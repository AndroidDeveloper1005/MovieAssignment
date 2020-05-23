package com.example.movieassignment.ui.adapter

import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.databinding.MovieCreditItemBinding
import com.example.movieassignment.model.MovieDetailBaseModel

class MovieCreditViewHolder(val binding : MovieCreditItemBinding, val viewModel : BaseViewModel?=null)
    : BaseViewHolder<MovieDetailBaseModel>(binding.root){
    override fun update(item: MovieDetailBaseModel) {
        binding.movieCredit = item
    }

}
