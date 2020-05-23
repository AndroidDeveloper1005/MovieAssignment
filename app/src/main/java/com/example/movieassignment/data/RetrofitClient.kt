package com.example.movieassignment.data

import com.example.movieassignment.utilities.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient{

    fun getMovieApiService() : MovieApiService{
        val retrofit  = Retrofit.Builder()
                        .baseUrl(Constant.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

        return retrofit.create(MovieApiService::class.java)
    }
}