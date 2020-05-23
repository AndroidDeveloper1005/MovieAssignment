package com.example.movieassignment.ui.movie_detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.*
import com.example.movieassignment.utilities.NetworkDetector
import kotlinx.coroutines.launch

class MovieDetailViewModel(application: Application) : BaseViewModel(application){

    val mutableMovieDetails = MutableLiveData<MovieDetail>()

    val mutableMovieCreditData = MutableLiveData<MovieCredits>()

    val mutableSimilarMovieList = MutableLiveData<List<SimilarMovieItem>>()

    var movieCastList : List<Cast> ? =null

    var movieCrewList : List<Crew> ? =null

    var movieId = -1L

    init {
        showLoading.set(true)
    }

    fun getMovieDetails(selectedMovieId: Long) {

        if (!NetworkDetector.isInternetAvailable(getApplication())){
            return
        }

        movieId = selectedMovieId
        viewModelScope.launch {
            val response = movieRepository.getSelectedMovieDetails(movieId)
            showLoading.set(false)
            if (response is Response.Success){
                mutableMovieDetails.value = response.value
            }

        }
    }

    fun getMovieCredits(selectedMovieId: Long){

        if (!NetworkDetector.isInternetAvailable(getApplication())){
            return
        }

        if (movieId!=selectedMovieId){
            movieId = selectedMovieId
        }
        viewModelScope.launch {
            val response = movieRepository.getMovieCredit(selectedMovieId)

            showLoading.set(false)

            if (response is Response.Success){
                if (!response.value.cast.isNullOrEmpty() || !response.value.crew.isNullOrEmpty()){
                    mutableMovieCreditData.value = response.value
                    movieCastList = response.value.cast
                    movieCrewList = response.value.crew
                }
            }
        }
    }

    fun getSimilarMovies(selectedMovieId: Long){

        if (!NetworkDetector.isInternetAvailable(getApplication())){
            return
        }

        if (movieId!=selectedMovieId){
            movieId = selectedMovieId
        }

        viewModelScope.launch {
            val response = movieRepository.getSimilarMoviesList(movieId)

            showLoading.set(false)

            if (response is Response.Success){
                if (!response.value.results.isNullOrEmpty()){
                    mutableSimilarMovieList.value = response.value.results
                }
            }
        }
    }

    fun getMovieCast(): List<Cast>{
        return movieCastList!!
    }

    fun getMovieCrew() : List<Crew>{
        return movieCrewList!!
    }
}