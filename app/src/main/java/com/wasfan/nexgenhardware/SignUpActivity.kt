package com.wasfan.nexgenhardware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val registerBtn: Button = findViewById(R.id.registerBtn)
        val loginTV:TextView = findViewById(R.id.loginTV)

        registerBtn.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        loginTV.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}