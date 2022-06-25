package com.android.movieapp.data

import androidx.lifecycle.LiveData
import com.android.movieapp.network.API_KEY
import com.android.movieapp.network.RetrofitClient
import com.github.leonardoxh.livedatacalladapter.Resource

class MovieRepo {

    fun getMoviesList(pageNo:Int):LiveData<Resource<MovieListResponse>>{
        return RetrofitClient.getMovieService.getMovieList(API_KEY,pageNo)
    }
}