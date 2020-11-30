package by.training.rssreader.ui.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.training.rssreader.data.model.NewsChannel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*

class ChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val channelImage: ImageView = itemView.channelImageView
    private val channelName = itemView.channelNameTextView

    fun bind(channel: NewsChannel) {
        Glide.with(itemView)
            .load(channel.imageUrl)
            .centerCrop()
            .into(channelImage)
        channelName.text = channel.channelName
    }
}
