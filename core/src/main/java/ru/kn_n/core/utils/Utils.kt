package ru.kn_n.core.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.reactivex.rxjava3.functions.Consumer
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

object RxError {
    @JvmStatic
    fun doNothing(): Consumer<Throwable> = Consumer { Log.d("RxError", null, it) }
}

fun Fragment.showInfoAlertDialog(title: String, message:String){
    MaterialAlertDialogBuilder(this.requireContext())
        .setTitle(title)
        .setMessage(message)
        .setNeutralButton(resources.getString(R.string.btn_dialog_cancel)){ dialog, _ ->
            dialog.cancel()
        }
        .show()
}
