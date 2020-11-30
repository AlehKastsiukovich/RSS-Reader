package by.training.rssreader.ui.view.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.data.api.COUNTRY_US
import by.training.rssreader.data.model.Data
import by.training.rssreader.databinding.ActivityNewsBinding
import by.training.rssreader.ui.adapter.NewsAdapter
import by.training.rssreader.ui.view.activity.MainActivity.Companion.COUNTRY_NAME
import by.training.rssreader.ui.viewmodel.NewsViewModel
import by.training.rssreader.util.Status

class NewsActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        setUpRecyclerView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        observe()
    }

    private fun renderData(data: Data) {
        with(newsAdapter) {
            setData(data.articles)
            notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@NewsActivity)
        }
    }

    private fun initViewModel() {
        val country = intent.extras?.getString(COUNTRY_NAME)
        newsViewModel = NewsViewModel(country ?: COUNTRY_US)
    }

    private fun observe() {
        newsViewModel.getResource().observe(
            this,
            Observer {
                when (it.status) {
                    Status.LOADING -> {
                        with(binding) {
                            progressBar.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                    }
                    Status.ERROR -> {
                        with(binding) {
                            progressBar.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                        Toast.makeText(
                            this,
                            resources.getString(R.string.network_error),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Status.SUCCESS -> {
                        with(binding) {
                            progressBar.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                        }
                        renderData(it.data!!)
                    }
                }
            }
        )
    }
}
