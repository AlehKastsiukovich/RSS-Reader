package by.training.rssreader.api

import by.training.rssreader.entity.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://newsapi.org"
const val BBC_TOP_NEWS = "/v2/top-headlines?sources=bbc-news&apiKey=d1e4c2411b604f39a8337382cd33bb71"

interface NewsService {

    @GET(BBC_TOP_NEWS)
    fun getBBCTopNews(): Call<Data>

    object ServiceInitializer {
        val bbcNewsService: NewsService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsService::class.java)
    }
}
