package com.android.movieapp

import androidx.lifecycle.*
import com.android.movieapp.data.Movie
import com.android.movieapp.data.MovieListResponse
import com.android.movieapp.data.MovieRepo
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.github.leonardoxh.livedatacalladapter.Resource


class MovieViewModel(private val movieRepo: MovieRepo) : ViewModel(){
    val loadMoviePage: MutableLiveData<Int> =  MutableLiveData()

    val movieLiveData: LiveData<Resource<MovieListResponse>> = Transformations.switchMap(loadMoviePage) {
        return@switchMap movieRepo.getMoviesList(it)
    }

}

class MovieViewModelFactory(private val movieRepo: MovieRepo):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(movieRepo) as T
    }
}