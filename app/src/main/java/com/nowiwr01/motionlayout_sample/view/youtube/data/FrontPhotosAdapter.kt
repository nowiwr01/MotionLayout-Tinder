package com.nowiwr01.motionlayout_sample.view.youtube.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nowiwr01.motionlayout_sample.R

class FrontPhotosAdapter(
    private val sampleGridData: List<Item>
): RecyclerView.Adapter<FrontPhotosAdapter.YouTubeDemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeDemoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.layout_youtube_item -> YouTubeDemoViewHolder.CatRowViewHolder(itemView)
            R.layout.layout_youtube_header_item -> YouTubeDemoViewHolder.TextHeaderViewHolder(itemView)
            else -> throw IllegalStateException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: YouTubeDemoViewHolder, position: Int) {
        when (holder) {
            is YouTubeDemoViewHolder.TextHeaderViewHolder -> {
                holder.title.text = sampleGridData[position].title
            }
            is YouTubeDemoViewHolder.CatRowViewHolder -> {
                holder.textView.text = sampleGridData[position].title
                holder.imageView.setImageResource(sampleGridData[position].image)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.layout_youtube_header_item
            else -> R.layout.layout_youtube_item
        }
    }

    override fun getItemCount() = sampleGridData.size +1 // For text header and text description

    sealed class YouTubeDemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        class TextHeaderViewHolder(itemView: View) : YouTubeDemoViewHolder(itemView) {
            val title = itemView.findViewById<TextView>(R.id.text_header)
            val description = itemView.findViewById<TextView>(R.id.text_description)
        }

        class CatRowViewHolder(itemView: View) : YouTubeDemoViewHolder(itemView) {
            val imageView = itemView.findViewById(R.id.image_row) as ImageView
            val textView = itemView.findViewById(R.id.text_row) as TextView
        }
    }
}