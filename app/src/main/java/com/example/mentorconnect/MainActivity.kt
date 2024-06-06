package com.example.mentorconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mentorconnect.databinding.ActivityLoginBinding
import com.example.mentorconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.idLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }
        binding.btnRegister.setOnClickListener { validateRegistration() }
    }

    fun validateRegistration() {
        clearErrors()
        var formError = true
        val firstName = binding.etFirstName.text.toString()
        if (firstName.isBlank()) {
            formError = true
            binding.tilFirstName.error = getString(R.string.first_name_is_required)
        }
        val lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            formError = true
            binding.tilLastName.error = getString(R.string.last_name_is_required)
        }
        val codeHiveId = binding.etLastName.text.toString()
        if (codeHiveId.isBlank()) {
            formError = true
            binding.tilCodeHive.error = getString(R.string.codehiveid_is_required)
        }
        val email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            formError = true
            binding.tilEmail.error = getString(R.string.email_is_required)

        }
        val userName = binding.etUserName.text.toString()
        if (userName.isBlank()) {
            formError = true
            binding.tilUsername.error = getString(R.string.username_is_required)

        }
        val password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            formError = true
            binding.tilPassword.error = "Password  is required"

        }
        val confirmPassword = binding.etConfirmPassword.text.toString()
        if (confirmPassword.isBlank()) {
            formError = true
            binding.tilconfirmpassword.error = "Password confirmation  is required"

        }
        if (password != password) {
            formError = true
            binding.tilconfirmpassword.error = "Password & confirmation must much"
        }
        if(!formError){
            val registration = Registration(
                firstName = firstName,
                lastName = lastName,
                codeHiveId = codeHiveId,
                password=  password,
                username = userName,
                email= email
            )
        }
    }

    fun clearErrors(){
        binding.tilFirstName.error = null
        binding.tilLastName.error = null
        binding.tilEmail.error = null
        binding.tilCodeHive.error = null
        binding.tilUsername.error = null
        binding.tilPassword.error = null
        binding.tilconfirmpassword.error = null






    }
}