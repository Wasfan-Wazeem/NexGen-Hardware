package com.wasfan.nexgenhardware

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wasfan.nexgenhardware.adapters.AdSliderAdapter
import com.wasfan.nexgenhardware.adapters.CategoriesAdapter
import com.wasfan.nexgenhardware.adapters.DetailsImagesAdapter
import com.wasfan.nexgenhardware.adapters.DetailsSliderAdapter
import com.wasfan.nexgenhardware.adapters.QuantityAdapter
import com.wasfan.nexgenhardware.adapters.recommendedAdapter
import com.wasfan.nexgenhardware.dataClass.CategoriesDataClass

class DetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val backBtn: ImageView = findViewById(R.id.backBtn)
        val viewPager: ViewPager2 = findViewById(R.id.slider)
        val dotsIndicator: DotsIndicator = findViewById(R.id.dotIndicator)
        val imagesListRecyclerView: RecyclerView = findViewById(R.id.imagesList)
        val quantityRecyclerView: RecyclerView = findViewById(R.id.quantityList)

        //viewPager
        val images = listOf(
            R.drawable.bosch_drill_1,
            R.drawable.bosch_drill_2,
            R.drawable.bosch_drill_3,
            R.drawable.bosch_drill_4,
            R.drawable.bosch_drill_5,
            R.drawable.bosch_drill_6,
            R.drawable.bosch_drill_7,
            R.drawable.bosch_drill_8,
            R.drawable.paint_bucket
        )

        val adapter = DetailsSliderAdapter(images)

        viewPager.adapter = adapter
        if (images.size > 1) {
            dotsIndicator.visibility = View.VISIBLE
            dotsIndicator.attachTo(viewPager)
        }

        //ImagesList
        imagesListRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val imagesListAdapter = DetailsImagesAdapter(this, images)
        imagesListAdapter.setOnItemClickListener(object :
            DetailsImagesAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                viewPager.currentItem = position
            }
        })
        imagesListRecyclerView.adapter = imagesListAdapter

        //Quantity
        val quantities = listOf(
            "1","2","3","4","5","6","7"
        )
        quantityRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        quantityRecyclerView.adapter = QuantityAdapter(quantities)

        backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}