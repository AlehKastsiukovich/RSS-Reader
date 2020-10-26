package by.training.rssreader.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.training.rssreader.R
import by.training.rssreader.adapter.NewsAdapter
import by.training.rssreader.entity.NewsChannel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempArray = listOf<NewsChannel>(
            NewsChannel("", "BBC"),
            NewsChannel("", "NBC"),
            NewsChannel("", "NBA"),
        )
    }

//    private fun init() {
//        newsAdapter = NewsAdapter()
//
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter = newsAdapter
//        }
//
//        NewsService.ServiceInitializer
//            .bbcNewsService
//            .getBBCTopNews()
//            .enqueue(object : Callback<Data> {
//                override fun onResponse(call: Call<Data>, response: Response<Data>) {
//                    newsAdapter.setData(response.body()?.articles)
//                }
//
//                override fun onFailure(call: Call<Data>, t: Throwable) {
//                    Toast.makeText(
//                        this@MainActivity,
//                        "Sorry, we have internet issues, try later",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            })
//    }
}
