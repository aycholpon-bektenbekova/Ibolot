package com.example.ibolot.ui.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(it: String) {
    Glide.with(this).load(it).into(this)
}