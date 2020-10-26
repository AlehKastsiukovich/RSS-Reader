package by.training.rssreader.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.training.rssreader.R
import by.training.rssreader.entity.NewsChannel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val channelImage: ImageView = itemView.channelImageView
    private val channelName = itemView.channelNameTextView

    fun bind(channel: NewsChannel) {
        Glide.with(itemView)
            .load(channel.imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .into(channelImage)
        channelName.text = channel.channelName
    }
}
