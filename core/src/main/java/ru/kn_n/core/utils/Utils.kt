package ru.kn_n.core.utils

import android.content.res.Resources
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import ru.kn_n.core.R

val String.Companion.EMPTY: String
    get() = ""

val Int.Companion.ZERO: Int
    get() = 0

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.isShow(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

fun loadImage(view: View, url: String, place: ImageView) {
    Glide.with(view)
        .load(url)
        .into(place)
}

fun getStringResource(id: Int):String = Resources.getSystem().getString(id)
