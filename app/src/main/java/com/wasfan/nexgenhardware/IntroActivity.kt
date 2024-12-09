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
            IntroViewPagerDataClass("Get ready for", "New Hardware", "If you want stationary products then this is for you!\nHere you can explore the beauty of the world of\nconstruction hardware", R.drawable.img_1),
            IntroViewPagerDataClass("All types of hardware items", "at one place", "Good Luck", R.drawable.intro_image_2),
            IntroViewPagerDataClass("Get ready for", "New Hardware", "Welcom back again", R.drawable.img_1)
        )
        val adapter = IntroViewPagerAdapter(pages)
        viewPager.adapter = adapter
        if(pages.size>1){
            dotsIndicator.visibility = View.VISIBLE
            dotsIndicator.attachTo(viewPager)
        }

        getStartedBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}