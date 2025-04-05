package com.levytskyi.example.myfooddelivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.levytskyi.example.myfooddelivery.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodImage = intent.getIntExtra("foodImage", 0)
        val foodName = intent.getStringExtra("foodName")

        binding.menuDetailsFoodImage.setImageResource(foodImage)
        binding.menuDetailFoodName.text = foodName

        binding.backHome.setOnClickListener{
            finish()
        }

    }
}