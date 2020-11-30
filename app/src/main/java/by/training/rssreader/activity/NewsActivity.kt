package by.training.rssreader.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.adapter.NewsAdapter
import by.training.rssreader.api.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_news.*
import java.lang.IllegalArgumentException

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
        Log.d("TAG", intent.extras?.get(COUNTRY_NAME).toString())
        return intent.extras?.get(COUNTRY_NAME).toString()
    }

    private fun chooseCountry(country: String) {
        val query = countryHandler(country)
        val result = NewsService.ServiceInitializerFactory
            .getNewsInstance()
            .getNews(country = query, apiKey = API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    Log.d("TAG", it.articles[0].title)
                    newsAdapter.setData(it.articles)
                },
                {
                    Toast.makeText(
                        this,
                        "Cant upload data!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
    }

    private fun countryHandler(country: String): String {
        return when (country) {
            COUNTRY_US -> "us"
            COUNTRY_CA -> "ca"
            COUNTRY_RUS -> "ru"
            else -> throw IllegalArgumentException()
        }
    }
}
