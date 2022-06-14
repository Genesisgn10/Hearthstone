package com.genesis.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.genesis.meals.R

fun ImageView.loadingImage(url: String?) {
    Glide
        .with(context)
        .load(url)
        .placeholder(R.drawable.icon)
        .error(R.drawable.ic_launcher_background)
        .fallback(R.drawable.icon)
        .centerCrop()
        .into(this)
}

fun View.setVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}