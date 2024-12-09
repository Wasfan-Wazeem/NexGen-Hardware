package com.wasfan.nexgenhardware

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.wasfan.nexgenhardware.adapters.AdSliderAdapter
import com.wasfan.nexgenhardware.adapters.CategoriesAdapter
import com.wasfan.nexgenhardware.adapters.DetailsSliderAdapter
import com.wasfan.nexgenhardware.adapters.recommendedAdapter
import com.wasfan.nexgenhardware.dataClass.CategoriesDataClass
import com.wasfan.nexgenhardware.dataClass.recommendedDataClass

class ExploreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewpagerSlider)
        val dotsIndicator: DotsIndicator = view.findViewById(R.id.dotsIndicator)
        val progressBarSlider: ProgressBar = view.findViewById(R.id.progressBarBanner)

        val recommendedRecyclerView: RecyclerView = view.findViewById(R.id.recommendationRecyclerView)
        val categoriesRecyclerView: RecyclerView = view.findViewById(R.id.categoriesRecyclerView)

        //Banner
        val images = listOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3
        )

        val adapter = AdSliderAdapter(images)
        viewPager.adapter = adapter
        if(images.size>1){
            progressBarSlider.visibility = View.GONE
            dotsIndicator.visibility = View.VISIBLE
            dotsIndicator.attachTo(viewPager)
        }


        //Categories
        val categories = listOf(
            CategoriesDataClass(R.drawable.tools, "Tools"),
            CategoriesDataClass(R.drawable.electrical, "Electrical"),
            CategoriesDataClass(R.drawable.fasteners, "Fasteners"),
            CategoriesDataClass(R.drawable.paint, "Paint"),
            CategoriesDataClass(R.drawable.gardening, "Gardening")
        )

        categoriesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoriesRecyclerView.adapter = CategoriesAdapter(categories)


        //recommended
        val recommendeds = listOf(
            recommendedDataClass(R.drawable.bosch_drill_1, "Rs.25,299.00", "Bosch Impact Drill", 4.5),
            recommendedDataClass(R.drawable.hammer, "Rs.1,020.00", "Claw Hammer", 3.9),
            recommendedDataClass(R.drawable.screwdriver, "Rs.520.00", "Screw Driver", 5.0),
            recommendedDataClass(R.drawable.paint_bucket, "Rs.750.00", "Monarch 1L Paint", 4.6),
            recommendedDataClass(R.drawable.hammer, "Rs.1,020.00", "Claw Hammer", 4.9),
            recommendedDataClass(R.drawable.screwdriver, "Rs.520.00", "Screw Driver", 2.7),
            recommendedDataClass(R.drawable.bosch_drill_1, "Rs.25,299.00", "Bosch Impact Drill", 4.5),
            recommendedDataClass(R.drawable.hammer, "Rs.1,020.00", "Claw Hammer", 3.9),
            recommendedDataClass(R.drawable.screwdriver, "Rs.520.00", "Screw Driver", 5.0),
        )

        recommendedRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val recomAdapter = recommendedAdapter(requireContext(), recommendeds)
        recomAdapter.setOnItemClickListener(object :
            recommendedAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                    val intent = Intent(context, DetailsActivity::class.java)
                    startActivity(intent)
            }
        })
        recommendedRecyclerView.adapter = recomAdapter

        return view
    }
}
