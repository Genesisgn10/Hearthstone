package com.genesis.extensions

import android.view.View
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.genesis.meals.R
import com.genesis.presenter.model.HearthstoneUiModel

fun ImageView.loadingImage(url: String?) {
    Glide
        .with(context)
        .load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .fallback(R.drawable.ic_launcher_background)
        .centerCrop()
        .into(this)
}

fun View.findNavController(@IdRes id: Int, chave: String, hearthstone: HearthstoneUiModel) {
    val bundle = bundleOf(chave to hearthstone)
    return this.findNavController().navigate(id, bundle)
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