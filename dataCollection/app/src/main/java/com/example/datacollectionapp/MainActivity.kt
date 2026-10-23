package com.example.datacollectionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
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
        var gender= "Rather not say"
        genderRadioButtongroup.setOnCheckedChangeListener { group, id ->
            when(id){
                R.id.radioButtonFemale->gender = "Female"
                R.id.radioButtonMale-> gender = "Male"
                R.id.radioButtonOther-> gender = "Other"
            }
        }
        nameTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
        ageTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
        val intent = Intent(this, DisplayDataActivity::class.java)
        submitButton.setOnClickListener {
            val age = ageTextInput.text.toString().toIntOrNull() ?: 0
            if (nameTextInput.text.isEmpty()) {
                ageTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
                Toast.makeText(this, "Enter a value for name", Toast.LENGTH_SHORT).show()
                nameTextInput.background =
                    AppCompatResources.getDrawable(this, R.drawable.warning_bg)
            } else if (age == 0) {
                nameTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
                Toast.makeText(this, "Enter a value for age", Toast.LENGTH_SHORT).show()
                ageTextInput.background =
                    AppCompatResources.getDrawable(this, R.drawable.warning_bg)
            } else {
                nameTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
                ageTextInput.background = AppCompatResources.getDrawable(this, R.drawable.normal_bg)
                userList.add(
                    User(
                        nameTextInput.text.toString(),
                        age,
                        gender
                    )
                )
                println(ageTextInput.text.toString())
                intent.putExtra(Constants.SENDER1, userList[0].name)
                intent.putExtra(Constants.SENDER2, userList[0].gender)
                intent.putExtra(Constants.SENDER3, userList[0].age)
                startActivity(intent)
                finish()
            }
        }

    }
}

private data class User(val name: String, val age: Int?, val gender: String)
