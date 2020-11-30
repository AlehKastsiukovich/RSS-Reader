package by.training.rssreader.data.api

import by.training.rssreader.data.model.Data
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org"
const val API_KEY = "d1e4c2411b604f39a8337382cd33bb71"
const val COUNTRY_US = "us"
const val COUNTRY_CA = "ca"
const val COUNTRY_RUS = "ru"

interface NewsService {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getNews(@Query("country") country: String): Observable<Data>

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
