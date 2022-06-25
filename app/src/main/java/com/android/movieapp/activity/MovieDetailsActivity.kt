package com.android.movieapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.android.movieapp.R
import com.android.movieapp.data.Movie
import com.android.movieapp.utils.GlideImageLoader
import com.android.movieapp.utils.ImageLoader
import com.google.gson.Gson

class MovieDetailsActivity : AppCompatActivity() {

    companion object {
        private val gson by lazy { Gson() }
        const val MOVIE_DATA = "movie_daya"
        fun getIntent(context: Context, movie:Movie){
            val intent = Intent(context,MovieDetailsActivity::class.java)
            intent.putExtra(MOVIE_DATA, gson.toJson(movie))
            context.startActivity(intent)
        }
    }

    private val imageLoader:ImageLoader by lazy {
        GlideImageLoader()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        intent.getStringExtra(MOVIE_DATA)?.let {
            gson.fromJson(it,Movie::class.java)?.let {
                initMovieView(it)
            }
        }
        findViewById<ImageView>(R.id.iv_back)?.let {
            it.setOnClickListener { finish() }
        }


    }

    fun initMovieView(movie: Movie){
        findViewById<TextView>(R.id.movie_title)?.let {
            it.text = movie.title
        }
        findViewById<ImageView>(R.id.movie_image)?.let {
            imageLoader.loadImage("https://image.tmdb.org/t/p/w500" + movie.posterPath,it)
        }
        findViewById<TextView>(R.id.release_date).let {
            it.text = movie.releaseDate
        }
        findViewById<TextView>(R.id.star_rating)?.let {
            it.text = movie.voteAverage.toString()
        }
        findViewById<TextView>(R.id.popularity)?.let {
            it.text = movie.popularity.toString()
        }
        findViewById<TextView>(R.id.tv_desc).let {
            it.text = movie.overview
        }
    }


}