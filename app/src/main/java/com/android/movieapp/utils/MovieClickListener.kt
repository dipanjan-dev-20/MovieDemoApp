package com.android.movieapp.utils

import com.android.movieapp.data.Movie

interface MovieClickListener {
    fun onMovieClick(movie: Movie)
}