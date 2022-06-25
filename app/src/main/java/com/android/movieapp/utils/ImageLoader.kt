package com.android.movieapp.utils

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(url:String,imageView: ImageView)
}