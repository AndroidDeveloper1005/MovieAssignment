package com.example.movieassignment.ui.home_page

import android.app.Application
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieassignment.MovieApp
import com.example.movieassignment.R
import com.example.movieassignment.base.BaseViewModel
import com.example.movieassignment.model.Movie
import com.example.movieassignment.model.Response
import com.example.movieassignment.utilities.NetworkDetector
import com.example.movieassignment.utilities.toast
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application){

    val appOpened = ObservableBoolean(true)

    val toolbarTitle = ObservableField("MoviePlex")

    val showSearch = ObservableBoolean(true)

    var selectedMovieId : Long = -1

    val latestMovieList = MutableLiveData<List<Movie>>();

    var PAGE_NO = 1;

    fun getLatestMovies(){

        if (!NetworkDetector.isInternetAvailable(getApplication())){
            showLoading.set(false)
            showFailureScreen.set(true)
            return
        }

        viewModelScope.launch {
            val response = movieRepository.getLatestMovie(PAGE_NO)
            showLoading.set(false)
            if (response is Response.Success){
                if (response.value.results!=null &&
                    !response.value.results.isNullOrEmpty()){
                    latestMovieList.value = response.value.results
                }

                Toast.makeText(getApplication(), "" +
                        "success: "+response.value.results?.size,
                        Toast.LENGTH_LONG).show()
            }
            if (response is Response.Error){
                showFailureScreen.set(true)
            }
        }
    }

}