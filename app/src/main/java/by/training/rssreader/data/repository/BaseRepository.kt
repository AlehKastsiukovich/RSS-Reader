package by.training.rssreader.data.repository

import by.training.rssreader.data.api.NewsService
import by.training.rssreader.data.model.Data
import io.reactivex.Observable

class BaseRepository(private val api: NewsService) {

    fun getData(country: String): Observable<Data> {
        return api.getNews(country)
    }
}
