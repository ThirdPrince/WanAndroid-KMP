package me.dhl.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import me.dhl.common.model.Article
import me.dhl.common.vm.ArticleViewModel



@Composable
fun App() {
    SideNavDemo()
//    Column {
//        val apiService = RetrofitManager.apiService
//        val repo = Repository(apiService)
//        val articleViewModel = ArticleViewModel(repo)
//        articleViewModel.fetchArticles(0)
//        ArticleListScreen(articleViewModel)
//    }
}

@Composable
fun ArticleListScreen(articleViewModel: ArticleViewModel) {
    val articles by articleViewModel.articles.collectAsState(initial = Result.success(emptyList()))
    when {
        articles.isSuccess -> {
            ArticleList(articles.getOrNull())
        }
        articles.isFailure -> {
            Text(text = "Error loading articles")
        }
        else -> {
            Text(text = "Loading...")
        }
    }
}

@Composable
fun ArticleList(articles: List<Article>?) {
    LazyColumn {
        items(articles ?: emptyList()) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Text(text = article.title)
}
