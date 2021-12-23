package com.behzoddev.architecturecomponentsample.common

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.behzoddev.architecturecomponentsample.R
import com.squareup.picasso.Picasso
import org.jetbrains.annotations.NotNull

fun ImageView.loadUrlWithPicasso(
    @NotNull url: String,
    placeholder: Drawable = this.context.getDrawable(R.drawable.ic_launcher_background)!!,
    error: Drawable = this.context.getDrawable(R.drawable.ic_launcher_foreground)!!
) {
    Picasso.get()
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .into(this)
}