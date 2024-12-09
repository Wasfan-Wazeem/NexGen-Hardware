package com.wasfan.nexgenhardware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationActivity : BaseActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set default selected item
        bottomNavigationView.selectedItemId = R.id.navigation_explore

        // Set item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_explore -> {
                    selectedFragment = ExploreFragment()
                }
                R.id.navigation_cart -> {
                    startActivity(Intent(this, CartActivity::class.java))
                }
                R.id.navigation_my_order -> {
                    selectedFragment = MyOrderFragment()
                }
                R.id.navigation_profile -> {
                    selectedFragment = ProfileFragment()
                }
            }
            selectedFragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, it).commit()
            }
            true
        }

        // Manually display the first fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ExploreFragment()).commit()
    }
}