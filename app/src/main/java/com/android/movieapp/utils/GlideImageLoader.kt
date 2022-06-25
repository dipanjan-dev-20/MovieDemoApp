package com.android.movieapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : ImageLoader {
    override fun loadImage(url: String, imageView: ImageView) {
        Glide.with(imageView).load(url).into(imageView)
    }

}