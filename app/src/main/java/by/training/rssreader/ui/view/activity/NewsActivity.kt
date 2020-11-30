package by.training.rssreader.ui.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.ui.adapter.NewsAdapter
import by.training.rssreader.ui.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news.recyclerView

class NewsActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsViewModel = NewsViewModel()

        newsAdapter = NewsAdapter()
        recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@NewsActivity)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
