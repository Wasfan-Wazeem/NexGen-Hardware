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

class recommendedAdapter(private val context: Context, private val itemList: List<recommendedDataClass>) : RecyclerView.Adapter<recommendedAdapter.ItemViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    class ItemViewHolder(itemView: View, listener:onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.pic)
        val priceTxt: TextView = itemView.findViewById(R.id.priceTxt)
        val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        val ratingTXT: TextView = itemView.findViewById(R.id.ratingTxt)

        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recommended_item_container, parent, false)
        return ItemViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.priceTxt.text = currentItem.price
        holder.titleTxt.text = currentItem.title
        holder.ratingTXT.text = currentItem.rating.toString()
    }

    override fun getItemCount(): Int = itemList.size

}