package me.dhl.common.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.dhl.common.api.ApiService




class Repository(private val apiService: ApiService) {

    suspend fun getArticles(pageNum: Int): Result<List<Article>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getSquareList(pageNum)
                Result.success(response.body()!!.data.datas)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}


