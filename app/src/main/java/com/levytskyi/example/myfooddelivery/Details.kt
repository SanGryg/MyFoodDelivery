package com.levytskyi.example.myfooddelivery

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.levytskyi.example.myfooddelivery.databinding.ActivityDetails2Binding
import com.levytskyi.example.myfooddelivery.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetails2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backStack.setOnClickListener {
            onBackPressed()
        }

        binding.placeMyOrder.setOnClickListener {
            val bottomFragment = SuccessPayment()
            bottomFragment.show(supportFragmentManager, "Test")
        }

        val totalPrice = intent.getStringExtra("totalPrice")
        binding.price.text = totalPrice
    }
}