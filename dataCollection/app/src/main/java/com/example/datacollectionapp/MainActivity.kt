package com.example.datacollectionapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var nameTextInput: EditText
    private lateinit var ageTextInput: EditText
    private lateinit var genderRadioButtongroup: RadioGroup
    private lateinit var javaCheckbox: CheckBox
    private lateinit var kotlinCheckbox: CheckBox
    private lateinit var cCheckbox: CheckBox
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        nameTextInput = findViewById(R.id.editTextTextName)
        ageTextInput = findViewById(R.id.editTextAge)
        genderRadioButtongroup = findViewById(R.id.radioGroupGender)
        javaCheckbox = findViewById(R.id.javaCheckbox)
        kotlinCheckbox = findViewById(R.id.kotlinCheckbox)
        cCheckbox = findViewById(R.id.cCheckbox)
        submitButton = findViewById(R.id.submitButton)
        val userList = mutableListOf<User>()
        lateinit var gender: String
        genderRadioButtongroup.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.radioButtonFemale->gender = "Female"
                R.id.radioButtonMale-> gender = "Male"
                R.id.radioButtonOther-> gender = "Other"
            }
        }
        submitButton.setOnClickListener{
            userList.add(User(nameTextInput.text.toString(), ageTextInput.text.toString().toInt(), gender))
        }

    }
}

private data class User(val name: String, val age: Int, val gender: String)
