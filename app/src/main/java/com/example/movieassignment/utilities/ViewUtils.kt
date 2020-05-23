package com.example.movieassignment.utilities

import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieassignment.R
import com.example.movieassignment.model.Movie


fun ImageView.loadImage(url: String) {
    if (isUrlValid(url)) {
        val imagePath = Constant.IMAGE_BASE_URL + url
        Glide.with(this.context).load(imagePath).into(this)
    }
}

@BindingAdapter(value = ["app:image"])
fun setImageToImageView(view: ImageView, path: String?) {
    if (isUrlValid(path)) {
        val imagePath = Constant.IMAGE_BASE_URL + path
        Glide.with(view.context).load(imagePath).dontTransform().dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL).override(60, 100).thumbnail(0.5f)
            .into(view)

    }
}

@BindingAdapter(value = ["app:otherDetails"])
fun setOtherDetails(view: TextView, movie : Movie){
    if (!TextUtils.isEmpty(movie.overview)) {
        val otherDetails = "popularity: " + movie.popularity + "overview: " + movie.overview
        view.setText(otherDetails)
    }
}
