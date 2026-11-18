package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ComposeShader
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

class ColorPickerBackground(context: Context, attrs: AttributeSet): View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var hueColor = Color.RED

    fun setHue(hue: Float) {
        hueColor = Color.HSVToColor(floatArrayOf(hue, 1f, 1f))
        updateShader()
        invalidate()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateShader()
    }

    private fun updateShader() {
        if (width <= 0 || height <= 0) return

        // Horizontal: White to Pure Hue
        val satShader = LinearGradient(
            0f, 0f, width.toFloat(), 0f,
            Color.WHITE, hueColor, Shader.TileMode.CLAMP
        )

        // Vertical: White (no darkening) to Black (full darkening)
        val valShader = LinearGradient(
            0f, 0f, 0f, height.toFloat(),
            Color.WHITE, Color.BLACK, Shader.TileMode.CLAMP
        )

        // Multiply blends the two gradients accurately
        paint.shader = ComposeShader(satShader, valShader, PorterDuff.Mode.MULTIPLY)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}