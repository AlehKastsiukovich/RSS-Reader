package by.training.rssreader.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.training.rssreader.R
import by.training.rssreader.entity.Article
import com.bumptech.glide.Glide

class NewsAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    private var data = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        Glide
            .with(holder.itemView.context)
            .load(data[position].urlToImage)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .into(holder.newsImage)

        holder.newsTitle.text = data[position].title
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<Article>?) {
        this.data = data as MutableList<Article>
        notifyDataSetChanged()
    }
}
