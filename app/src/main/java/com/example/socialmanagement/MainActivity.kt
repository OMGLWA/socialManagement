package com.example.socialmanagement

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //Code Starts Here
    //ViewCompact
    // Declarations
    private lateinit var spTimeOfDay: Spinner
    private lateinit var suggestion: TextView
    private lateinit var btnReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Variables and Constraints

        spTimeOfDay = findViewById(R.id.spTimeOfDay)
        suggestion = findViewById(R.id.suggestion)
        btnReset = findViewById(R.id.btnMainReset)

        //Logic for Spinner

        spTimeOfDay.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                //Responses
                val message = when (position) {
                    0 -> "Please select a time of day." //Enter The App
                    1 -> "Send a 'Good morning' text to a Family member." //Morning
                    2 -> "Reach out to a colleage with a quick 'Thank you'." //Mid-Morning
                    3 -> "Share a funny meme or interesting link with a freind." //Afternoon 
                    4 -> "Send a quick 'Think of you' message." //Afternoon Snack Time
                    5 -> "Call a friend or relative for a 5-minute catch-up." //Dinner
                    6 -> "Leave a thoughtful comment on a friend's post." //After Dinner
                    else -> "Please select a time of day."
                }
                suggestion.text = message

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }.also { spTimeOfDay.onItemSelectedListener = it }

        //Logic for Reset Button
        btnReset.setOnClickListener {
            suggestion.text=""
            spTimeOfDay.setSelection(0)
        }
    }
}