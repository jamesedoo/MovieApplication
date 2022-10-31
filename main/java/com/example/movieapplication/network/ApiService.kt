package com.example.movieapplication.network

import com.example.movieapplication.MovieResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "dd47317644b37e45e43df140398da19e"
    ): Call<MovieResponse>

    @POST("now_playing?api_key=dd47317644b37e45e43df140398da19e")
    fun postNowPLaying(
        @Query("api_key") apiKey: String = "dd47317644b37e45e43df140398da19e"
    ): Call<MovieResponse>

    @POST("now_playing?api_key=dd47317644b37e45e43df140398da19e")
    fun postNowPLaying(): Call<MovieResponse>
}