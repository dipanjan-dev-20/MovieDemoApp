package com.android.movieapp.network

import androidx.lifecycle.LiveData
import com.android.movieapp.data.MovieListResponse
import com.github.leonardoxh.livedatacalladapter.Resource
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val API_KEY = "38a73d59546aa378980a88b645f487fc"
interface MovieService {
    @GET("movie/now_playing")
    fun getMovieList(
    @Query("api_key") apiKey:String,
    @Query("page") page:Int = 1
    ) : LiveData<Resource<MovieListResponse>>
}

