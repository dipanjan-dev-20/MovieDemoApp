package com.android.movieapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.movieapp.MovieViewModel
import com.android.movieapp.MovieViewModelFactory
import com.android.movieapp.R
import com.android.movieapp.data.Movie
import com.android.movieapp.data.MovieRepo
import com.android.movieapp.ui.MovieListAdapter
import com.android.movieapp.utils.GlideImageLoader
import com.android.movieapp.utils.ImageLoader
import com.android.movieapp.utils.MovieClickListener

class MoviesListActivity : AppCompatActivity(),MovieClickListener {
    lateinit var rv :RecyclerView
    lateinit var movieListAdapter: MovieListAdapter
    private val imageLoader:ImageLoader by lazy { GlideImageLoader() }
    private lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
        initViewModel()
    }

    fun initRecycler(){
        movieListAdapter = MovieListAdapter(this,imageLoader)
        rv = findViewById(R.id.recycler_view)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = movieListAdapter
    }

    fun initViewModel(){
        viewModel = ViewModelProvider(this,MovieViewModelFactory(MovieRepo()))[MovieViewModel::class.java]
        viewModel.movieLiveData.observe(this){
            it.resource?.results?.let {
                movieListAdapter.setMovieList(it)
            }
        }
        viewModel.loadMoviePage.value = 1
    }

    override fun onMovieClick(movie: Movie) {
        MovieDetailsActivity.getIntent(this,movie)
    }
}