package com.wasfan.nexgenhardware.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wasfan.nexgenhardware.R
import com.wasfan.nexgenhardware.dataClass.IntroViewPagerDataClass

class DetailsSliderAdapter(private val imageResId: List<Int>) : RecyclerView.Adapter<DetailsSliderAdapter.PageViewHolder>() {

    inner class PageViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageSlide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ad_slider_item_container, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val pageItem = imageResId[position]
        holder.image.setImageResource(pageItem)
    }

    override fun getItemCount(): Int {
        return imageResId.size
    }
}