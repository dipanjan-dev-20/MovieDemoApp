package com.android.movieapp.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.utils.ImageLoader
import com.android.movieapp.R
import com.android.movieapp.data.Movie
import com.android.movieapp.utils.MovieClickListener

class MovieViewHolder(
    itemView: View,
    private val listener: MovieClickListener,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(movie: Movie) {
        val imageView = itemView.findViewById<ImageView>(R.id.movie_image)
        val movieTitle = itemView.findViewById<TextView>(R.id.movie_title)
        val movieDesc = itemView.findViewById<TextView>(R.id.movie_desc)
        imageLoader.loadImage("https://image.tmdb.org/t/p/w200" + movie.posterPath, imageView)
        movieTitle.text = movie.title
        movieDesc.text = movie.overview
        itemView.setOnClickListener {
            listener.onMovieClick(movie)
        }

    }
}