package com.nowiwr01.motionlayout_sample.view.youtube.data

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Item(
    val title: String,
    @DrawableRes val image: Int
): Serializable