package me.dhl.common.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import me.dhl.common.model.Article
import me.dhl.common.model.Repository


class ArticleViewModel(private val repository: Repository) {

    private val _articles = MutableStateFlow<Result<List<Article>>>(Result.failure(Exception("No data")))
    val articles: StateFlow<Result<List<Article>>> = _articles

     fun fetchArticles(pageNum: Int) {
         CoroutineScope(Dispatchers.IO).launch {
             _articles.value = repository.getArticles(0)
         }

    }
}

