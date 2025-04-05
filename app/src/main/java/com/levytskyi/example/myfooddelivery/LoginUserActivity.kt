package com.levytskyi.example.myfooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.levytskyi.example.myfooddelivery.databinding.ActivityLoginUserBinding

class LoginUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSignUpUser.setOnClickListener {
            val intent = Intent(
                this@LoginUserActivity, SignUpUserActivity::class.java
            )
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(
                this@LoginUserActivity, MainActivity::class.java
            )
            startActivity(intent)
            finish()
        }
    }
}