package by.training.rssreader.ui.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.training.rssreader.R
import by.training.rssreader.data.api.COUNTRY_CA
import by.training.rssreader.data.api.COUNTRY_RUS
import by.training.rssreader.data.api.COUNTRY_US
import by.training.rssreader.data.model.NewsChannel
import by.training.rssreader.ui.adapter.ChannelAdapter
import kotlinx.android.synthetic.main.activity_main.channelsRecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var channelsAdapter: ChannelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        val tempArray = listOf(
            NewsChannel(CA_URL, COUNTRY_CA),
            NewsChannel(RU_URL, COUNTRY_RUS),
            NewsChannel(USA_URL, COUNTRY_US),
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

    companion object {
        private const val CA_URL = "https://images.dailyhive.com/20190122132035/shutterstock_533849170.jpg"
        private const val RU_URL = "https://www.globalconstructionreview.com/client_media/images/russ_1.jpg"
        private const val USA_URL = "https://as01.epimg.net/en/imagenes/2020/05/02/other_sports/1588371859_519106_1588419306_noticia_normal.jpg"
        const val COUNTRY_NAME = "COUNTRY"
    }
}
