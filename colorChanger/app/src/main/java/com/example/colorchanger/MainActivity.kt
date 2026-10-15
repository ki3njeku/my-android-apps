package com.example.colorchanger

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var red: Button
    private lateinit var green: Button
    private lateinit var blue: Button
    private lateinit var random: Button
    private lateinit var screen: ConstraintLayout
    private lateinit var text: TextView
    private var colors = arrayOf(Color.RED, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.CYAN, Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        red = findViewById(R.id.redButton)
        green = findViewById(R.id.greenButton)
        blue = findViewById(R.id.blueButton)
        random = findViewById(R.id.random)
        screen = findViewById(R.id.main)
        text = findViewById(R.id.textView2)
        red.setOnClickListener {
            screen.setBackgroundColor(getColor(R.color.red))
            text.setTextColor(getColor(R.color.white))
        }
        green.setOnClickListener{
            screen.setBackgroundColor(getColor(R.color.green))
            text.setTextColor(getColor(R.color.white))
        }
        blue.setOnClickListener {
            screen.setBackgroundColor(getColor(R.color.blue))
            text.setTextColor(getColor(R.color.white))
        }
        random.setOnClickListener {
            screen.setBackgroundColor(colors[Random.nextInt(colors.size)])
            text.setTextColor(getColor(R.color.white))
        }

    }
}