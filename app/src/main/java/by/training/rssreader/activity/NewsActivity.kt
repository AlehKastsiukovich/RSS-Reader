package by.training.rssreader.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.adapter.NewsAdapter
import by.training.rssreader.api.API_KEY
import by.training.rssreader.api.NewsService
import by.training.rssreader.entity.Data
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        newsAdapter = NewsAdapter()

        recyclerView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@NewsActivity)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val country = getCountryName()

        chooseCountry(country)
    }

    private fun getCountryName(): String {
        return intent.extras?.get("COUNTRY").toString()
    }

    private fun chooseCountry(country: String) {
        NewsService.ServiceInitializerFactory
            .getNewsInstance()
            .getNews(country = country, apiKey = API_KEY)
            .enqueue(object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    newsAdapter.setData(response.body()?.articles)
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Toast.makeText(
                        this@NewsActivity,
                        "Sorry, we have internet issues, try later",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}
