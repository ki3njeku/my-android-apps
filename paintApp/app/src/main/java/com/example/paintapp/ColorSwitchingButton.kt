package com.example.paintapp

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class ColorSwitchingButton(context: Context, attrs: AttributeSet): AppCompatButton(context, attrs) {
    var currentColor: Int? = null
    init {
        this.backgroundTintList = ColorStateList.valueOf((currentColor ?: Color.WHITE))
    }
}