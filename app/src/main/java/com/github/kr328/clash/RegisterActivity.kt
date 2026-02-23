package com.github.kr328.clash

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        
        // Simple implementation that redirects back to login
        Toast.makeText(this, "Registration feature would be implemented here", Toast.LENGTH_LONG).show()
        finish() // Go back to login screen
    }
}