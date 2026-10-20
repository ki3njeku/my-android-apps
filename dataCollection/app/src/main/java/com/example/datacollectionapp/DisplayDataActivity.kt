package com.example.datacollectionapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DisplayDataActivity : AppCompatActivity() {
    private lateinit var userInfo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)
        userInfo = findViewById(R.id.brandon)
        val message = intent.extras
        var name: String? = null
        var gender: String? = null
        var age = 0
        message?.let{
            name = message.getString(Constants.SENDER1)
            gender = message.getString(Constants.SENDER2)
            age = message.getInt(Constants.SENDER3)
        }
        Toast.makeText(this, name ?: "No name", Toast.LENGTH_SHORT).show()
        val textToDisplay = "Name: $name\nAge: $age\nGender: $gender"
        userInfo.text =  textToDisplay
    }
}