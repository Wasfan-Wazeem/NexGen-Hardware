package com.wasfan.nexgenhardware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wasfan.nexgenhardware.adapters.IntroViewPagerAdapter
import com.wasfan.nexgenhardware.dataClass.IntroViewPagerDataClass

class IntroActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val viewPager: ViewPager2 = findViewById(R.id.viewPagerIntro)
        val dotsIndicator: DotsIndicator = findViewById(R.id.dotsIndicator)
        val getStartedBtn: Button = findViewById(R.id.getStartedBtn)

        val pages = listOf(
            IntroViewPagerDataClass(
                "Browse Products Easily",
                "Discover Hardware",
                "Explore a wide range of hardware tools and accessories with detailed product information and prices at your fingertips.",
                R.drawable.img_1
            ),
            IntroViewPagerDataClass(
                "All Your Hardware Needs",
                "In One App",
                "Find tools, equipment, and materials for your projects. Call us directly to place your order effortlessly.",
                R.drawable.intro_image_2
            ),
            IntroViewPagerDataClass(
                "Personalized Service",
                "Order with Ease",
                "Review products, check prices, and contact our team for assistance. We're here to help with your hardware needs!",
                R.drawable.img_1
            )
        )

        val adapter = IntroViewPagerAdapter(pages)
        viewPager.adapter = adapter
        if(pages.size>1){
            dotsIndicator.visibility = View.VISIBLE
            dotsIndicator.attachTo(viewPager)
        }

        getStartedBtn.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }

    }
}