package com.example.countriesquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.animation.AnimationUtils

class NewMainActivity : AppCompatActivity() {
    private lateinit var nextButton: AppCompatButton
    private lateinit var flagsButton: ImageButton
    private lateinit var capitalsButton: ImageButton
    private var currentChoice: Short = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_main_activity)
        nextButton = findViewById(R.id.next_button)
        flagsButton = findViewById(R.id.flag_button)
        capitalsButton = findViewById(R.id.capitals_button)
        setOnClick(capitalsButton)
        setOnClick(flagsButton)
        setOnClick(nextButton)
    }

    fun setSelectionAnime(view: View){
        if(view.isActivated){
            android.view.animation.AnimationUtils.loadAnimation(this, R.anim.select_anime).also{
                view.startAnimation(it)
            }
        }
    }
    fun setOnClick(view: View){
        view.setOnClickListener {
            when(view.id){
                R.id.next_button->{
                    Intent(this, NewQuestionsActivity::class.java).also{
                        startActivity(it)
                        it.putExtra("MISKA MUSKA MOUSE KA TOOLS", currentChoice)
                    }
                }
                R.id.capitals_button->{
                    currentChoice = 0
                    view.isActivated = true
                    resetSize(flagsButton)
                    Toast.makeText(this, "This hasn't been implemented yet", Toast.LENGTH_SHORT).show()
                }
                R.id.flag_button->{
                    view.isActivated = true
                    resetSize(capitalsButton)
                    currentChoice = 1
                }
            }
            setSelectionAnime(view)
        }
    }
    fun resetSize(view: View){
        view.scaleY = 1f
        view.scaleX = 1f
        view.isActivated = false
    }
}