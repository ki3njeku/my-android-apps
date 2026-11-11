package com.example.paintapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var occupied1: ColorSwitchingButton
    private lateinit var occupied2: ColorSwitchingButton
    private lateinit var occupied3: ColorSwitchingButton
    private lateinit var occupied4: ColorSwitchingButton
    private lateinit var drawingView: DrawingView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        drawingView = findViewById(R.id.canvas)
        occupied1 = findViewById(R.id.occupied_1)
        occupied2 = findViewById(R.id.occupied_2)
        occupied3 = findViewById(R.id.occupied_3)
        occupied4 = findViewById(R.id.occupied_4)
        occupied1.currentColor = Color.RED
        occupied2.currentColor = Color.GREEN
        occupied3.currentColor = Color.BLUE
        occupied4.currentColor = Color.BLACK
        val occupiedColors = listOf(occupied1, occupied2, occupied3, occupied4)
        for(occupiedColor in occupiedColors){
            occupiedColor.backgroundTintList = ColorStateList.valueOf(occupiedColor.currentColor!!)
            occupiedColor.setOnClickListener {
                drawingView.changeBrushColor(occupiedColor.currentColor!!)
            }
        }
    }
}