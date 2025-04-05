package com.levytskyi.example.myfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.levytskyi.example.myfooddelivery.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goUserLoginBtn.setOnClickListener {
            val intent = Intent(this@StartActivity, LoginUserActivity:: class.java)
            startActivity(intent)
            finish()
        }
    }
}