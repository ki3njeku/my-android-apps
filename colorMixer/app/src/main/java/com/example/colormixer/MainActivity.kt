package com.example.colormixer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.color.DynamicColors

class MainActivity : AppCompatActivity() {
    private lateinit var picker: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        picker = findViewById(R.id.pickButton)
        val intent = Intent(this@MainActivity, MixColors::class.java)
        picker.setOnClickListener {
            startActivity(intent)
        }
    }
}