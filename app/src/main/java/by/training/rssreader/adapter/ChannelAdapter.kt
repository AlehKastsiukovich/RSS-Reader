package by.training.rssreader.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.training.rssreader.R
import by.training.rssreader.entity.NewsChannel

class ChannelAdapter(val clickListener: (news: NewsChannel) -> Unit) : RecyclerView.Adapter<ChannelViewHolder>() {

    private var channels = mutableListOf<NewsChannel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        holder.bind(channels[position])
        holder.itemView.setOnClickListener {
            clickListener(channels[position])
        }
    }

    override fun getItemCount(): Int {
        return channels.size
    }

    fun setData(data: List<NewsChannel>) {
        channels = data as MutableList<NewsChannel>
        notifyDataSetChanged()
    }
}
