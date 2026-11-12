package com.example.paintapp

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatButton

class ColorSwitchingButton(context: Context, attrs: AttributeSet): AppCompatButton(context, attrs) {
    var currentColor: Int? = null
    init {
        this.backgroundTintList = ColorStateList.valueOf((currentColor ?: Color.WHITE))
    }
    fun activateColor(){
        this.background = AppCompatResources.getDrawable(context, R.drawable.selected_color)
        this.scaleX = 1.25f
        this.scaleY = 1.25f
    }
    fun deactivateColor(){
        this.background = AppCompatResources.getDrawable(context, R.drawable.color_button_background)
        this.scaleX = 1f
        this.scaleY = 1f
    }
}