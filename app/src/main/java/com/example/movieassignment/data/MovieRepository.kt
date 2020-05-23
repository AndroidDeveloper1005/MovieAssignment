package com.example.movieassignment.data

import com.example.movieassignment.MovieApp
import com.example.movieassignment.model.*
import com.example.movieassignment.utilities.Constant

class MovieRepository(application: MovieApp) {

    val TAG by lazy {
        javaClass.simpleName
    }

    val movieService by lazy {
        RetrofitClient.getMovieApiService()
    }

    suspend fun getLatestMovie(pageNo : Int): Response<LatestMovie> {
        val response = movieService.getLatestMovies(Constant.API_KEY, pageNo)
        return callApi { response }
    }

    suspend fun getSelectedMovieDetails(movieId : Long) : Response<MovieDetail>{
        val response = movieService.getMovieDetails(movieId , Constant.API_KEY)
        return callApi { response }
    }

    suspend fun getMovieCredit(movieId: Long) : Response<MovieCredits>{
        val response = movieService.getMovieCredits(movieId, Constant.API_KEY)
        return callApi { response }
    }

    suspend fun getSimilarMoviesList(movieId: Long) : Response<SimilarMovies>{
        val response = movieService.getSimilarMoviesList(movieId, Constant.API_KEY)
        return callApi { response }
    }

    private suspend fun <T> callApi(apiCall: suspend() -> T) : Response<T>{
        return try{
            Response.Success(apiCall.invoke())
        }catch (throwable : Exception){
            Response.Error(exception = throwable)
        }
    }
}