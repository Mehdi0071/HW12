package com.example.staticrandomimage

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("loaded")
fun loadImg(img : ImageView,isLoadImg : Boolean) {

    if (isLoadImg)
        img.visibility = View.VISIBLE
    else
        img.visibility = View.GONE

}
