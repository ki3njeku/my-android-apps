package com.example.countriesquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var progressView: TextView
    private lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.questionsSeekBar)
        progressView = findViewById(R.id.progressView)
        startButton = findViewById(R.id.startButton)
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progressView.text = seekBar?.progress.toString()
                progressView.visibility = View.VISIBLE
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                progressView.text = seekBar?.progress.toString()
                progressView.visibility = View.VISIBLE
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                progressView.text = seekBar?.progress.toString()
                progressView.visibility = View.VISIBLE
            }
        })
        startButton.setOnClickListener {
            val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra(Constants.KEY1, progressView.text.toString())
            startActivity(intent)
        }
    }

}