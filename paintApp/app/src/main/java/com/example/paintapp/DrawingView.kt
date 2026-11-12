package com.example.paintapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {
    private lateinit var drawPath: FingerPath
    private var paths: MutableList<FingerPath> = mutableListOf()

    private lateinit var drawPaint: Paint
    private var color = Color.BLACK
    private lateinit var canvas: Canvas
    private lateinit var canvasPaint: Paint
    private lateinit var canvasBitmap: Bitmap
    private var brushSize: Float = 0f
    init{
        setUp()
    }

    @SuppressLint("UseKtx")
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(canvasBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(canvasBitmap, 0f, 0f, drawPaint)
        for(path in paths){
            if(!path.isEmpty){
                drawPaint.strokeWidth = path.brushThickness
                drawPaint.color = path.color
                canvas.drawPath(path, drawPaint)
            }
        }
        if(!drawPath.isEmpty){
            drawPaint.strokeWidth = drawPath.brushThickness
            drawPaint.color = drawPath.color
            canvas.drawPath(drawPath, drawPaint)
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        val touchY = event?.y
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                drawPath.color = color
                drawPath.brushThickness =brushSize
                drawPath.reset()
                drawPath.moveTo(touchX!!, touchY!!)
            }

            MotionEvent.ACTION_MOVE->{
                drawPath.lineTo(touchX!!, touchY!!)
            }

            MotionEvent.ACTION_UP->{
                paths.add(drawPath)
                drawPath = FingerPath(color, brushSize)
            }
            else -> return false

        }
        invalidate()
        return true
    }
    fun setUp(){
        drawPath = FingerPath(color, brushSize)
        drawPaint = Paint()
        drawPaint.color = color
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeCap = Paint.Cap.ROUND
        drawPaint.strokeJoin = Paint.Join.ROUND
        brushSize = 20f
        canvasPaint = Paint(Paint.DITHER_FLAG)
    }

    fun changeBrushColor(newColor: Int){
        color = newColor
    }
    fun undo(){
        if(paths.isNotEmpty()) {
            invalidate()
            paths.removeAt(paths.size - 1)
        }
    }
    internal inner class FingerPath(var color: Int, var brushThickness: Float) : Path(){

    }
}