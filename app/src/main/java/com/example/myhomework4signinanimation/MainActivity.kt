package com.example.myhomework4signinanimation

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myhomework4signinanimation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var valueAnimator: ValueAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        valueAnimator = ValueAnimator.ofInt(0, 30, 0, 0, -30, 0)
        valueAnimator.duration = 400
        valueAnimator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            binding.linear.translationX = animatedValue.toFloat()
        }

        binding.btAnmationLogin.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this@MainActivity, "Sign In Successfully", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty() && password.isEmpty()) {
                valueAnimator.start()
            }
        }
    }
}