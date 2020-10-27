package by.training.rssreader.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news.view.*

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val newsImage = itemView.presentNewsImageView
    val newsTitle = itemView.presentNewsTitleTextView
}
