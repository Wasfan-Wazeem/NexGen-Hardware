package com.wasfan.nexgenhardware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val getStartedBtn: Button = findViewById(R.id.getStartedBtn)
        val signupTV:TextView = findViewById(R.id.signupTV)

        getStartedBtn.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

        signupTV.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}