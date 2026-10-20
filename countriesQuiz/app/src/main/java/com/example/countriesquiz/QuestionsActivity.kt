package com.example.countriesquiz

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import kotlin.random.Random

val countryNames = listOf(
    "Andorra", "United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Anguilla",
    "Albania", "Armenia", "Angola", "Antarctica", "Argentina", "American Samoa", "Austria",
    "Australia", "Aruba", "Åland Islands", "Azerbaijan", "Bosnia and Herzegovina", "Barbados",
    "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Burundi", "Benin",
    "Saint Barthélemy", "Bermuda", "Brunei", "Bolivia", "Bonaire, Sint Eustatius and Saba",
    "Brazil", "Bahamas", "Bhutan", "Bouvet Island", "Botswana", "Belarus", "Belize",
    "Canada", "Cocos (Keeling) Islands", "Congo (Democratic Republic of the)",
    "Central African Republic", "Congo (Republic of the)", "Switzerland", "Côte d'Ivoire",
    "Cook Islands", "Chile", "Cameroon", "China", "Colombia", "Costa Rica", "Cuba",
    "Cabo Verde", "Curaçao", "Christmas Island", "Cyprus", "Czechia", "Germany",
    "Djibouti", "Denmark", "Dominica", "Dominican Republic", "Algeria", "Ecuador",
    "Estonia", "Egypt", "Western Sahara", "Eritrea", "Spain", "Ethiopia", "Finland",
    "Fiji", "Falkland Islands", "Micronesia", "Faroe Islands", "France", "Gabon",
    "Wales", "United Kingdom", "Northern Ireland", "Scotland", "Grenada", "Georgia",
    "French Guiana", "Guernsey", "Ghana", "Gibraltar", "Greenland", "Gambia", "Guinea",
    "Guadeloupe", "Equatorial Guinea", "Greece", "South Georgia and the South Sandwich Islands",
    "Guatemala", "Guam", "Guinea-Bissau", "Guyana", "Hong Kong", "Heard Island and McDonald Islands",
    "Honduras", "Croatia", "Haiti", "Hungary", "Indonesia", "Ireland", "Israel",
    "Isle of Man", "India", "British Indian Ocean Territory", "Iraq", "Iran", "Iceland",
    "Italy", "Jersey", "Jamaica", "Jordan", "Japan", "Kenya", "Kyrgyzstan", "Cambodia",
    "Kiribati", "Comoros", "Saint Kitts and Nevis", "Korea (North)", "Korea (South)",
    "Kuwait", "Cayman Islands", "Kazakhstan", "Laos", "Lebanon", "Saint Lucia",
    "Liechtenstein", "Sri Lanka", "Liberia", "Lesotho", "Lithuania", "Luxembourg",
    "Latvia", "Libya", "Morocco", "Monaco", "Moldova", "Montenegro", "Saint Martin (French part)",
    "Madagascar", "Marshall Islands", "North Macedonia", "Mali", "Myanmar", "Mongolia",
    "Macao", "Northern Mariana Islands", "Martinique", "Mauritania", "Montserrat",
    "Malta", "Mauritius", "Maldives", "Malawi", "Mexico", "Malaysia", "Mozambique",
    "Namibia", "New Caledonia", "Niger", "Norfolk Island", "Nigeria", "Nicaragua",
    "Netherlands", "Norway", "Nepal", "Nauru", "Niue", "New Zealand", "Oman", "Panama",
    "Peru", "French Polynesia", "Papua New Guinea", "Philippines", "Pakistan", "Poland",
    "Saint Pierre and Miquelon", "Pitcairn", "Puerto Rico", "Palestine", "Portugal",
    "Palau", "Paraguay", "Qatar", "Réunion", "Romania", "Serbia", "Russia", "Rwanda",
    "Saudi Arabia", "Solomon Islands", "Seychelles", "Sudan", "Sweden", "Singapore",
    "Saint Helena, Ascension and Tristan da Cunha", "Slovenia", "Svalbard and Jan Mayen",
    "Slovakia", "Sierra Leone", "San Marino", "Senegal", "Somalia", "Suriname",
    "South Sudan", "Sao Tome and Principe", "El Salvador", "Sint Maarten (Dutch part)",
    "Syria", "Eswatini", "Turks and Caicos Islands", "Chad", "French Southern Territories",
    "Togo", "Thailand", "Tajikistan", "Tokelau", "Timor-Leste", "Turkmenistan",
    "Tunisia", "Tonga", "Türkiye", "Trinidad and Tobago", "Tuvalu", "Taiwan",
    "Tanzania", "Ukraine", "Uganda", "United States Minor Outlying Islands",
    "United States of America", "Uruguay", "Uzbekistan", "Holy See (Vatican City)",
    "Saint Vincent and the Grenadines", "Venezuela", "Virgin Islands (British)",
    "Virgin Islands (U.S.)", "Vietnam", "Vanuatu", "Wallis and Futuna", "Samoa",
    "Kosovo", "Yemen", "Mayotte", "South Africa", "Zambia", "Zimbabwe"
)

class QuestionsActivity : AppCompatActivity() {
    //val countries = Countries.loadDrawableIds(this)
    lateinit var flagImage: ImageView
    lateinit var choice1: RadioButton
    lateinit var choice2: RadioButton
    lateinit var choice3: RadioButton
    lateinit var choice4: RadioButton
    lateinit var radioGroup: RadioGroup
    lateinit var result: TextView
    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        val typedArray = resources.obtainTypedArray(R.array.country_array)
        val drawableIds = IntArray(typedArray.length()) { i ->
            typedArray.getResourceId(i, 0)
        }
        typedArray.recycle()
        flagImage = findViewById(R.id.flag)
        choice1 = findViewById(R.id.choice1)
        choice2 = findViewById(R.id.choice2)
        choice3 = findViewById(R.id.choice3)
        choice4 = findViewById(R.id.choice4)
        radioGroup = findViewById(R.id.choicesGroup)
        result = findViewById(R.id.result)
        nextButton = findViewById(R.id.next)
        nextButton.text = getText(R.string.next)
        nextButton.setOnClickListener {
            recreate()
            result.visibility = View.INVISIBLE
            radioGroup.clearCheck()
        }

        val randomIndex = Random.nextInt(drawableIds.size)
        val correctAnswer = countryNames[randomIndex]
        val answers = populateRadioButtons(randomIndex)

        choice1.text = answers[0]
        choice2.text = answers[1]
        choice3.text = answers[2]
        choice4.text = answers[3]

        var correctAnswerId = choice1
        for (choice in listOf(choice1, choice2, choice3, choice4)){
            if(choice.text == correctAnswer){
                correctAnswerId = choice
            }
        }
        radioGroup.setOnCheckedChangeListener { _, id ->
            when(id){
                correctAnswerId.id->{
                    result.visibility = View.VISIBLE
                    result.text = getString(R.string.correct_answer)
                    result.setTextColor(Color.GREEN)
                }
                else -> {
                    result.visibility = View.VISIBLE
                    result.text = getString(R.string.wrong_answer)
                    result.setTextColor(Color.RED)
                }
            }

        }
        flagImage.setImageDrawable(AppCompatResources.getDrawable(this, drawableIds[randomIndex]))
    }
}

fun populateRadioButtons(correctIndex: Int): MutableList<String>{
    val correctAnswer = countryNames[correctIndex]
    val countryNamesCopy = countryNames.toMutableList()
    countryNamesCopy.remove(correctAnswer)
    val answers = mutableListOf(correctAnswer)
    repeat(3) {
        val randomCountryIndex = Random.nextInt(countryNamesCopy.size)
        answers.add(countryNamesCopy[randomCountryIndex])
        countryNamesCopy.removeAt(randomCountryIndex)
    }
    answers.shuffle()
    return answers
}