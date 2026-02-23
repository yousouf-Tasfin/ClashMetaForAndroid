package com.github.kr328.clash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var loginButton: Button
    private lateinit var registerLink: TextView
    private lateinit var forgotPasswordLink: TextView
    private lateinit var rememberMeCheckbox: CheckBox
    private lateinit var progressBar: ProgressBar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        initViews()
        setupClickListeners()
    }
    
    private fun initViews() {
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginButton = findViewById(R.id.login_button)
        registerLink = findViewById(R.id.register_link)
        forgotPasswordLink = findViewById(R.id.forgot_password_link)
        rememberMeCheckbox = findViewById(R.id.remember_me_checkbox)
        progressBar = findViewById(R.id.progress_bar)
    }
    
    private fun setupClickListeners() {
        loginButton.setOnClickListener {
            performLogin()
        }
        
        registerLink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        
        forgotPasswordLink.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
    
    private fun performLogin() {
        val username = usernameInput.text.toString().trim()
        val password = passwordInput.text.toString()
        
        if (validateInputs(username, password)) {
            showLoading(true)
            
            // Simulate login process
            Thread {
                try {
                    Thread.sleep(2000) // Simulate network delay
                    
                    runOnUiThread {
                        showLoading(false)
                        
                        // Simple validation - in real app, this would be API call
                        if (username == "admin" && password == "password") {
                            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_LONG).show()
                        }
                    }
                } catch (e: Exception) {
                    runOnUiThread {
                        showLoading(false)
                        Toast.makeText(this, "Login failed: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                }
            }.start()
        }
    }
    
    private fun validateInputs(username: String, password: String): Boolean {
        return when {
            username.isEmpty() -> {
                showError("Username cannot be empty")
                false
            }
            password.isEmpty() -> {
                showError("Password cannot be empty")
                false
            }
            password.length < 6 -> {
                showError("Password must be at least 6 characters")
                false
            }
            else -> true
        }
    }
    
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    
    private fun showLoading(show: Boolean) {
        if (show) {
            progressBar.visibility = android.view.View.VISIBLE
            loginButton.isEnabled = false
        } else {
            progressBar.visibility = android.view.View.GONE
            loginButton.isEnabled = true
        }
    }
}