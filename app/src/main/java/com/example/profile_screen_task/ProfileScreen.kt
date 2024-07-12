package com.example.profile_screen_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import com.example.profile_screen_task.databinding.ActivityProfileScreenBinding

class ProfileScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowBack.setOnClickListener {
            val intent = Intent(this, LoginScreen ::class.java)
            startActivity(intent)
            finish()
        }

        binding.linkedinIcon.setOnClickListener {
            val link = "https://www.linkedin.com/in/nrmeen-sadek?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app".toUri()
            val intent = Intent(Intent.ACTION_VIEW, link)
            startActivity(intent)
        }

        binding.githupIcon.setOnClickListener {
            val link = "https://github.com/nrmeenmohamed".toUri()
            val intent = Intent(Intent.ACTION_VIEW, link)
            startActivity(intent)
        }

        binding.facebookIcon.setOnClickListener {
            val link = "https://www.google.com/".toUri()
            val intent = Intent(Intent.ACTION_VIEW, link)
            startActivity(intent)
        }

        binding.name.text = intent.getStringExtra("name")
        binding.email.text = intent.getStringExtra("email")
        binding.age.text = intent.getStringExtra("age")
        binding.jop.text = intent.getStringExtra("jop")

    }
}