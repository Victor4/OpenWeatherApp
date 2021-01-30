package com.victor.desafio_box

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.victor.desafio_box.activities.HomeActivity
import com.victor.desafio_box.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var activityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}

