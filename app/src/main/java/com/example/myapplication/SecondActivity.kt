package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val receivedData: Tip? = intent.getParcelableExtra("tipData") as Tip?
        receivedData?.let { data ->
            binding.tvTipAmount.text = "Tip Amount: ${data.tip}"
            binding.tvTotalAmount.text = "Total Amount: ${data.totalAmount}"
        }
        val tipAmount = binding.tvTipAmount.text.toString()
        val totalAmount = binding.tvTotalAmount.text.toString()
        val replaceTipAmount = tipAmount.replace(" ", "%20")
        val replaceTotalAmount = totalAmount.replace(" ", "%20")
        Log.d("SIMPLE_TAG", "$replaceTipAmount%0A$replaceTotalAmount")

        binding.btnSendReceipt.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://wa.me/6281952951440?text=$replaceTipAmount%0A$replaceTotalAmount")
            startActivity(intent)
        }
    }
}