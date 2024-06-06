package com.example.mentorconnect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mentorconnect.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.idSignup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }

        binding.btnLogin.setOnClickListener { validateLogIn()
        }
    }

fun validateLogIn() {


        clearErrors()
        var formError = false
        val userName = binding.etnUsername.text.toString()
        if (userName.isBlank()) {
            formError = true
            binding.til2username.error = getString(R.string.usenamer_name_is_required)
        }

    val password = binding.etnpassword.text.toString()
    if (password.isBlank()) {
        formError = true
        binding.til2password.error = getString(R.string.password_is_required)

    }


}

 fun clearErrors(){
    binding.til2username.error = null
    binding.til2password.error = null


  }
}