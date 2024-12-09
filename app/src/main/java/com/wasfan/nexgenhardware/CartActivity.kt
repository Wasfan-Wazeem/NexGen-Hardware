package com.wasfan.nexgenhardware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val backBtn:ImageView = findViewById(R.id.backBtn)

        backBtn.setOnClickListener {
            onBackPressed()
        }

    }
}