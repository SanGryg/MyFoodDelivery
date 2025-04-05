package com.levytskyi.example.myfooddelivery

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.levytskyi.example.myfooddelivery.Fragments.notification_bottom_fragment
import com.levytskyi.example.myfooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstancesState: Bundle?){
        super.onCreate(savedInstancesState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment_container)
        val notification_btn = findViewById<ImageView>(R.id.bell_not)

        notification_btn.setOnClickListener{
            val bottomSheetDialogFragment = notification_bottom_fragment()
            bottomSheetDialogFragment.show(supportFragmentManager, "Test")
        }

        bottomNav.setupWithNavController(navController)
    }
}