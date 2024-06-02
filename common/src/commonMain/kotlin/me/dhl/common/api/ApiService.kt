package me.dhl.common.api

import me.dhl.common.model.ArticleData
import me.dhl.common.model.HttpData
import retrofit2.Response
import retrofit2.http.*

/**
 * @Title: ApiService
 * @Package com.dhl.wanandroid.api
 * @Description: api
 * @author dhl
 * @date 2022 12-20
 * @version V2.0
 */
interface ApiService {


    /**
     * 广场
     *  https://wanandroid.com/user_article/list/0/json
     */
    @GET("user_article/list/{pageNum}/json")
    suspend fun getSquareList(@Path("pageNum") pageNum: Int): Response<HttpData<ArticleData>>

}