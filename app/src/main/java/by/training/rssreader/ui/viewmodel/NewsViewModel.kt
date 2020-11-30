package by.training.rssreader.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.training.rssreader.data.api.NewsService
import by.training.rssreader.data.model.Data
import by.training.rssreader.data.repository.BaseRepository
import by.training.rssreader.util.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(private val country: String) : ViewModel() {

    private val repository: BaseRepository
    private val api: NewsService = NewsService.ServiceInitializerFactory.getNewsInstance()
    private val resource = MutableLiveData<Resource<Data>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        repository = BaseRepository(api)
        fetchData()
    }

    fun getResource(): LiveData<Resource<Data>> {
        return resource
    }

    private fun fetchData() {
        resource.postValue(Resource.loading(null))
        compositeDisposable.add(
            repository.getData(country)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        resource.postValue(Resource.success(it))
                    },
                    {
                        resource.postValue(Resource.error("Error", null))
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
