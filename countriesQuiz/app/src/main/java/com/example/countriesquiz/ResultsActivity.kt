package com.example.countriesquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultsActivity : AppCompatActivity() {
    private lateinit var nameField: TextView
    private lateinit var scoreDisplay: TextView
    private lateinit var playAgain: Button
    private lateinit var exitButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        nameField = findViewById(R.id.congratsMessage)
        scoreDisplay = findViewById(R.id.scoreView)
        playAgain = findViewById(R.id.playAgain)
        exitButton = findViewById(R.id.exit)
        exitButton.setOnClickListener {
            finish()
        }
        playAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val extras = intent.extras
        val score = extras?.getInt(Constants.KEY2)
        val total = extras?.getInt(Constants.KEY5)
        val userName = extras?.getString(Constants.KEY4).toString()
        val message = "Congrats $userName"
        val performance = "$score / $total"
        nameField.text = message
        scoreDisplay.text = performance

    }
}