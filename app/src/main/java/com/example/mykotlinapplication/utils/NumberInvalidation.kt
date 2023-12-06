package com.example.mykotlinapplication.utils

import androidx.core.text.isDigitsOnly

fun String.transformerToFloat(): Float = if (this.isDigitsOnly()) this.toFloat() else 0f
