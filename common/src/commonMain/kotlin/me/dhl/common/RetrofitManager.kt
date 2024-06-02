package me.dhl.common

import me.dhl.common.api.ApiService
import me.dhl.common.api.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.Proxy
import java.util.concurrent.TimeUnit

/**
 * @Title: RetrofitManager
 * @Package $
 * @Description: Retrofit 基本封装
 * @author dhl
 * @date 2022-1220
 * @version V2.0
 */
object RetrofitManager {

    private const val CONNECTION_TIME_OUT = 10L
    private const val READ_TIME_OUT = 10L

    val apiService: ApiService by lazy { retrofit.create(ApiService::class.java) }

    /**
     * 懒加载
     */
    private val retrofit: Retrofit by lazy {
        buildRetrofit(Constants.BASE_URL, buildHttpClient())
    }




    /**
     * 构建自己的OKHttp
     */
    private fun buildHttpClient(): OkHttpClient.Builder {

        return OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .proxy(Proxy.NO_PROXY)

    }

    /**
     * 构建 Retrofit
     */
    private fun buildRetrofit(baseUrl: String, build: OkHttpClient.Builder): Retrofit {

        val client = build.build()
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(client).build()
    }

}