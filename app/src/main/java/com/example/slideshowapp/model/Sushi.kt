package com.example.slideshowapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Sushi(
    @DrawableRes val imageRes: Int,
    @StringRes val nameRes: Int
)
