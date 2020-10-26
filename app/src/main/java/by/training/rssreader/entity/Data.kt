package by.training.rssreader.entity

data class Data(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
