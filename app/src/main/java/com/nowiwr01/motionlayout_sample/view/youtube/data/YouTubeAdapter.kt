package com.nowiwr01.motionlayout_sample.view.youtube.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nowiwr01.motionlayout_sample.R
import kotlinx.android.synthetic.main.layout_youtube_item_main.view.*

class YouTubeAdapter(
    private val sampleGridData: List<Item>,
    private val onVideoClick: (Item) -> Unit
) : RecyclerView.Adapter<YouTubeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_youtube_item_main, parent, false)
        )
        holder.root.setOnClickListener {
            onVideoClick.invoke(sampleGridData[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(sampleGridData[position])

    override fun getItemCount() = sampleGridData.size

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Item) {
            with(root) {
                mainSmallTitle.text = item.title
                author.text = String.format("Video %s", adapterPosition)
                imageView.setImageResource(item.image)
            }
        }
    }
}