package com.github.kr328.clash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.github.kr328.clash.design.Design
import kotlinx.coroutines.launch

class LoginActivity : BaseActivity<Design<Unit>>() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override suspend fun main() {
        // Since we're not using the design system for this activity,
        // we just need to ensure the UI is set up properly
        // The UI is handled in onCreate via setContentView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Create a simple login layout programmatically
        setContentView(androidx.constraintlayout.widget.ConstraintLayout(this).apply {
            val padding = resources.getDimension(com.github.kr328.clash.design.R.dimen.main_padding_horizontal).toInt()
            
            usernameEditText = androidx.appcompat.widget.AppCompatEditText(context).also { editText ->
                editText.hint = "Username"
                editText.id = android.view.View.generateViewId()
                
                val lp = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_PARENT,
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topToTop = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    startToStart = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    setMargins(padding, padding, padding, 0)
                }
                
                addView(editText, lp)
            }
            
            passwordEditText = androidx.appcompat.widget.AppCompatEditText(context).also { editText ->
                editText.hint = "Password"
                editText.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
                editText.id = android.view.View.generateViewId()
                
                val lp = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.MATCH_PARENT,
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topToBottom = usernameEditText.id
                    startToStart = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    setMargins(padding, padding, padding, 0)
                }
                
                addView(editText, lp)
            }
            
            loginButton = androidx.appcompat.widget.AppCompatButton(context).also { button ->
                button.text = "Login"
                button.id = android.view.View.generateViewId()
                
                val lp = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topToBottom = passwordEditText.id
                    startToStart = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    endToEnd = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
                    setMargins(padding, padding * 2, padding, 0)
                }
                
                addView(button, lp)
            }
            
            loginButton.setOnClickListener {
                performLogin()
            }
        })
    }
    
    private fun performLogin() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        
        if (username == "admin" && password == "admin") {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
            // Start the main activity after successful login
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Invalid credentials. Use admin/admin.", Toast.LENGTH_LONG).show()
        }
    }
}