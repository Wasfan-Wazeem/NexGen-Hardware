package com.wasfan.nexgenhardware.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wasfan.nexgenhardware.R
import com.wasfan.nexgenhardware.dataClass.recommendedDataClass

class DetailsImagesAdapter(private val context: Context, private val itemList: List<Int>) : RecyclerView.Adapter<DetailsImagesAdapter.ItemViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    class ItemViewHolder(itemView: View, listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.pic)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.details_images_item, parent, false)
        return ItemViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val pageItem = itemList[position]
        holder.imageView.setImageResource(pageItem)
    }

    override fun getItemCount(): Int = itemList.size

}