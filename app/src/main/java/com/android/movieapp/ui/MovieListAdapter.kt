package com.android.movieapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.utils.ImageLoader
import com.android.movieapp.R
import com.android.movieapp.data.Movie
import com.android.movieapp.utils.MovieClickListener

class MovieListAdapter(
    private val listener: MovieClickListener,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<MovieViewHolder>() {
    private val movieList:MutableList<Movie> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_entity, parent, false),
            listener,
            imageLoader
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindTo(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size


    fun setMovieList(movie:List<Movie>){
        movieList.clear();
        movieList.addAll(movie)
        notifyDataSetChanged()
    }


}



