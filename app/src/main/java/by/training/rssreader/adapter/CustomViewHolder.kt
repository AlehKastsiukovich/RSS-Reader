package by.training.rssreader.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val newsImage: ImageView = itemView.presentNewsImageView
    val newsTitle: TextView = itemView.presentNewsTitleTextView
}
