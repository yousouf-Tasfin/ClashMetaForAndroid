package com.github.kr328.clash

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        
        // Simple implementation that redirects back to login
        Toast.makeText(this, "Forgot password feature would be implemented here", Toast.LENGTH_LONG).show()
        finish() // Go back to login screen
    }
}