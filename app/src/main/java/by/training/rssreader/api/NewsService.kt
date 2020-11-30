package by.training.rssreader.api

import by.training.rssreader.entity.Data
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org"
const val API_KEY = "d1e4c2411b604f39a8337382cd33bb71"
const val COUNTRY_US = "United States news"
const val COUNTRY_CA = "Canada news"
const val COUNTRY_RUS = "Russia news"

interface NewsService {

    @GET("/v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Observable<Data>

    object ServiceInitializerFactory {
        fun getNewsInstance(): NewsService {
            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(NewsService::class.java)
        }
    }
}
