package com.wasfan.nexgenhardware.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wasfan.nexgenhardware.R
import com.wasfan.nexgenhardware.dataClass.IntroViewPagerDataClass

class IntroViewPagerAdapter(private val pages: List<IntroViewPagerDataClass>) : RecyclerView.Adapter<IntroViewPagerAdapter.PageViewHolder>() {

    inner class PageViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        val text1: TextView = view.findViewById(R.id.text1)
        val text2: TextView = view.findViewById(R.id.text2)
        val text3: TextView = view.findViewById(R.id.text3)
        val image: ImageView = view.findViewById(R.id.introImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_slider, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val pageItem = pages[position]
        holder.text1.text = pageItem.text1
        holder.text2.text = pageItem.text2
        holder.text3.text = pageItem.text3
        holder.image.setImageResource(pageItem.imageResId)
    }

    override fun getItemCount(): Int {
        return pages.size
    }
}