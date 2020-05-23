package com.example.movieassignment.ui.adapter

import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.databinding.LatestMovieItemBinding
import com.example.movieassignment.model.Movie

class LatestMovieViewHolder(val binding : LatestMovieItemBinding,
                            val viewModel : BaseViewModel ? =null) : BaseViewHolder<Movie>(binding.root){

    override fun update(item: Movie) {
        binding.movieData = item
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }

}