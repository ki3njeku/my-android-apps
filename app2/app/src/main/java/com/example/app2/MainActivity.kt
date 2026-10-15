package com.example.app2

import android.animation.TypeConverter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputLength: EditText
    private lateinit var convert: Button
    private lateinit var answer: TextView
    private lateinit var toggle: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var direction = true
        inputLength = findViewById(R.id.inputLength)
        convert = findViewById(R.id.convert)
        answer = findViewById(R.id.Answer)
        inputLength.hint = getString(R.string.covert_to_inches)
        toggle = findViewById(R.id.toggle)
        answer.visibility = View.INVISIBLE
        convert.setOnClickListener {
            if(inputLength.text.toString().isNotEmpty()) {
                if (direction) {
                    answer.text = (inputLength.text.toString().toDouble() * 0.394).toString()
                } else {
                    answer.text = (inputLength.text.toString().toDouble() / 0.394).toString()
                }
                answer.visibility = View.VISIBLE
            }else if(!inputLength.text.toString().isDigitsOnly()){//redundant but still
                answer.text = "Enter only numbers"
                answer.visibility = View.VISIBLE
            }else{
                answer.text = "Enter a value"
                answer.visibility = View.VISIBLE

            }
        }
        toggle.setOnClickListener {
            direction = !direction
            inputLength.setText("")
            answer.visibility = View.INVISIBLE
            inputLength.hint = if(direction) getString(R.string.covert_to_inches) else getString(R.string.covert_to_cm)

        }

    }
}

