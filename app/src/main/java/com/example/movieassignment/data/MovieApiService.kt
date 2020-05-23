package com.example.movieassignment.data

import com.example.movieassignment.model.LatestMovie
import com.example.movieassignment.model.MovieCredits
import com.example.movieassignment.model.MovieDetail
import com.example.movieassignment.model.SimilarMovies
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService{

    @GET("movie/now_playing")
    suspend fun getLatestMovies(@Query("api_key") apiKey : String,
                                @Query("page") pageNo : Int) : LatestMovie

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") pathId :
                                    Long, @Query("api_key") apiKey : String) : MovieDetail

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path( "movie_id") movieId: Long,
                                @Query("api_key") apiKey: String):  MovieCredits

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMoviesList(@Path( "movie_id") movieId: Long,
                             @Query("api_key") apiKey: String): SimilarMovies

}