package com.ayanoguz.marvel.core

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("visibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("htmlText")
    fun htmlText(view: TextView, html: String?) {
        html?.let {
            view.text = HtmlCompat.fromHtml(
                html,
                0
            ).trim()
        }
    }

    @JvmStatic
    @BindingAdapter("visibilityNot")
    fun setVisibilityNot(view: View, isVisible: Boolean) {
        view.visibility = View.GONE
        if (isVisible.not()) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @JvmStatic
    @BindingAdapter("enabled")
    fun setEnabled(view: View, isEnabled: Boolean) {
        view.isEnabled = isEnabled
    }

    @JvmStatic
    @BindingAdapter("downloadImage")
    fun ImageView.downloadImage(url : String?) {
        url?.let {
            Picasso.get().cancelRequest(this)
            Picasso.get().load(url).fit().into(this)
        }
    }
}