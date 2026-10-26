package com.example.colormixer

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MixColors : AppCompatActivity() {
    private lateinit var redSeekBar: SeekBar
    private lateinit var greenSeekBar: SeekBar
    private lateinit var blueSeekBar: SeekBar
    private lateinit var redLabel: TextView
    private lateinit var greenLabel: TextView
    private lateinit var blueLabel: TextView
    private lateinit var backButton: Button
    private lateinit var preview: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mix_colors)

        //Initializing the components
        redSeekBar = findViewById(R.id.redSeekbar2)
        greenSeekBar = findViewById(R.id.greenSeekBar)
        blueSeekBar = findViewById(R.id.blueSeekbar2)
        redLabel = findViewById(R.id.redLabel)
        greenLabel = findViewById(R.id.greenLabel)
        blueLabel = findViewById(R.id.blueLabel)
        preview = findViewById(R.id.preview)
        backButton = findViewById(R.id.backButton)

        //Making the preview
        var redValue = 0
        var greenValue = 0
        var blueValue = 0
        var redValueFormatted:String
        var greenValueFormatted:String
        var blueValueFormatted:String
        var compositeColor: String
        redSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                redLabel.text = seekBar?.progress.toString()
                redValue = progress
                redValueFormatted = String.format("%02X", redValue)
                greenValueFormatted = String.format("%02X", greenValue)
                blueValueFormatted = String.format("%02X", blueValue)
                compositeColor = "#${redValueFormatted}${greenValueFormatted}${blueValueFormatted}"
                preview.setBackgroundColor(compositeColor.toColorInt())
                preview.setTextColor(Color.rgb(255-redValue, 255-greenValue, 255-blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        greenSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                greenLabel.text = seekBar?.progress.toString()
                greenValue = progress
                redValueFormatted = String.format("%02X", redValue)
                greenValueFormatted = String.format("%02X", greenValue)
                blueValueFormatted = String.format("%02X", blueValue)
                compositeColor = "#${redValueFormatted}${greenValueFormatted}${blueValueFormatted}"
                preview.setBackgroundColor(compositeColor.toColorInt())
                preview.setTextColor(Color.rgb(255-redValue, 255-greenValue, 255-blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        blueSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(
                seekBar: SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                blueLabel.text = seekBar?.progress.toString()
                blueValue = progress
                redValueFormatted = String.format("%02X", redValue)
                greenValueFormatted = String.format("%02X", greenValue)
                blueValueFormatted = String.format("%02X", blueValue)
                compositeColor = "#${redValueFormatted}${greenValueFormatted}${blueValueFormatted}"
                preview.setBackgroundColor(compositeColor.toColorInt())
                preview.setTextColor(Color.rgb(255-redValue, 255-greenValue, 255-blueValue))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        backButton.setOnClickListener {
            Intent(this, MainActivity::class.java).let {
                startActivity(it)
            }
        }

    }
}