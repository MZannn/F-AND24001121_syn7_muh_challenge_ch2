package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton: RadioButton = findViewById(checkedId)
            val selectedOption = radioButton.text
            Toast.makeText(this, "Selected Option: $selectedOption", Toast.LENGTH_SHORT).show()
        }
    }
}