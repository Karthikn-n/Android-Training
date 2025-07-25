package com.example.happybirthday.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)


data class Topic(
    @StringRes val stringResourceId: Int,
    val value: Int,
    @DrawableRes val imageResourceId: Int,
)