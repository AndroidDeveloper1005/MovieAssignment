package com.example.movieassignment.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movieassignment.MovieApp
import com.example.movieassignment.model.Movie
import com.example.movieassignment.utilities.NetworkDetector

abstract class BaseViewModel(application: Application) : AndroidViewModel(application){
    val TAG by lazy {
        javaClass.simpleName
    }

    val movieRepository by lazy{
        (application as MovieApp).getMovieRepository()
    }

    val clickedMovieItem = MutableLiveData<Movie>()

    val showLoading = ObservableBoolean(true)

    val showFailureScreen = ObservableBoolean(false)

    init {
        clickedMovieItem.value = null
    }

    fun onItemClicked(movieData : Movie){
        clickedMovieItem.value = movieData
    }

    fun checkInternetAndUpdateView(){
        if (!NetworkDetector.isInternetAvailable(getApplication())){
            showLoading.set(false)
            showFailureScreen.set(true)
            return
        }

    }

    fun resetView(){
        showLoading.set(true)
        showFailureScreen.set(false)
    }
}