package com.example.countriesquiz
//I think this one is simple enough to understand

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private lateinit var progressView: TextView
    private lateinit var startButton: Button
    private lateinit var userName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.questionsSeekBar)
        progressView = findViewById(R.id.progressView)
        startButton = findViewById(R.id.startButton)
        userName = findViewById(R.id.nameField)
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
            if(userName.text.isEmpty()){
                Toast.makeText(
                    this,
                    "Enter your name",
                    Toast.LENGTH_LONG
                ).show()
            }else if(seekBar.progress == 0) {
                Toast.makeText(
                    this,
                    "Enter the number of questions you want to try",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.KEY1, seekBar.progress)
                intent.putExtra(Constants.KEY3, userName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }

}