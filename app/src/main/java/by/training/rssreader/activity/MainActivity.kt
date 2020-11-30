package by.training.rssreader.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.adapter.ChannelAdapter
import by.training.rssreader.api.COUNTRY_CA
import by.training.rssreader.api.COUNTRY_RUS
import by.training.rssreader.api.COUNTRY_US
import by.training.rssreader.entity.NewsChannel
import kotlinx.android.synthetic.main.activity_main.*

const val COUNTRY_NAME = "COUNTRY"

class MainActivity : AppCompatActivity() {

    private lateinit var channelsAdapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempArray = listOf(
            NewsChannel("https://images.dailyhive.com/20190122132035/shutterstock_533849170.jpg", COUNTRY_CA),
            NewsChannel("https://www.globalconstructionreview.com/client_media/images/russ_1.jpg", COUNTRY_RUS),
            NewsChannel("https://as01.epimg.net/en/imagenes/2020/05/02/other_sports/1588371859_519106_1588419306_noticia_normal.jpg", COUNTRY_US),
        )

        channelsAdapter = ChannelAdapter { item ->
            openNewsByCountry(item.channelName)
        }

        channelsAdapter.setData(tempArray)

        channelsRecyclerView.apply {
            adapter = channelsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun openNewsByCountry(country: String) {
        startActivity(Intent(this, NewsActivity::class.java).putExtra(COUNTRY_NAME, country))
    }
}
