package com.example.profile_screen_task

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profile_screen_task.databinding.ActivityLoginScreenBinding

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        binding.btnSubmit.setOnClickListener {

            when{
                binding.etName.text.isEmpty() || binding.etName.text.length > 10 ->{
                    binding.etName.error = "\"First name must be filled and not exceed 10 characters"
                }
                binding.etEmail.text.isEmpty() || !binding.etEmail.text.matches(Regex(emailPattern)) ->{
                    binding.etEmail.error = "Email must be filled and be a valid email address"
                }
                binding.etAge.text.isEmpty() ->{
                    binding.etAge.error = "Age must be filled"
                }
                binding.etJop.text.isEmpty()  ->{
                    binding.etJop.error = "Jop must be filled"
                }
                else->{
                    val intent = Intent(this, ProfileScreen ::class.java)
                    intent.putExtra("name",binding.etName.text.toString())
                    intent.putExtra("email",binding.etEmail.text.toString())
                    intent.putExtra("age",binding.etAge.text.toString())
                    intent.putExtra("jop",binding.etJop.text.toString())
                    startActivity(intent)
                }
            }

        }
    }
}