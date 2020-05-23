package com.example.movieassignment

import android.app.Application
import com.example.movieassignment.data.MovieRepository

class MovieApp : Application(){

    var repository : MovieRepository ? =null

    override fun onCreate() {
        super.onCreate()
        initMovieRepository()
    }

    private fun initMovieRepository(){
        repository = MovieRepository(application = this)
    }

    fun getMovieRepository() : MovieRepository{
        return repository!!
    }
}