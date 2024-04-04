package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // Declare binding variable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Initialize binding
        setContentView(binding.root) // Set root view from binding

        Log.d("SIMPLE_TAG", "onCreate: Data")

        binding.btnCalculate.setOnClickListener {
            val amount = binding.editText.text.toString().toDoubleOrNull()
            val tipPercentage = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonOption1 -> 20.0
                R.id.radioButtonOption2 -> 18.0
                R.id.radioButtonOption3 -> 15.0
                else -> 0.0
            }
            if (amount == null && tipPercentage == 0.0){
                Toast.makeText(this, "Please enter amount and select tip percentage", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{
                val tip = calculateTip(amount!!, tipPercentage)
                val totalAmount = amount + tip
                val intent = Intent(this, SecondActivity::class.java)
                val tipData = Tip(tip, totalAmount)
                intent.putExtra("tipData", tipData)
                startActivity(intent)
            }
        }
    }

    private fun calculateTip(amount: Double, tipPercentage: Double): Double {
        return amount * tipPercentage / 100
    }
}