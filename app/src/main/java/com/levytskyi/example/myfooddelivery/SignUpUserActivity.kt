package com.levytskyi.example.myfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.levytskyi.example.myfooddelivery.databinding.ActivitySignUpUserBinding

class SignUpUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.goLoginUserPage.setOnClickListener {
            val intent = Intent(
                this@SignUpUserActivity, LoginUserActivity::class.java
            )
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(
                this@SignUpUserActivity, LocationActivity::class.java
            )
            startActivity(intent)
            finish()
        }

    }
}