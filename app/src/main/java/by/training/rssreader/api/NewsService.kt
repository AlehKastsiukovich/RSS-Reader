package by.training.rssreader.api

import by.training.rssreader.entity.Data
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org"
const val API_KEY = "d1e4c2411b604f39a8337382cd33bb71"
const val COUNTRY_US = "us"
const val COUNTRY_CA = "ca"
const val COUNTRY_RUS = "ru"

interface NewsService {

    @GET("/v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<Data>

    object ServiceInitializerFactory {
        fun getNewsInstance(): NewsService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
        }
    }
}
