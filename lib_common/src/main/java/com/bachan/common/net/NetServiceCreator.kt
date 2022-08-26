package com.bachan.common.net

import com.bachan.common.BuildConfig
import com.quyunshuo.common.constant.NetUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetServiceCreator {

    private const val BASE_URL = NetUrl.url1

    private const val CONNECT_TIME_OUT = 15L

    private const val READ_TIME_OUT = 20L

    /**
     * 获取service动态代理对象
     * @param serviceClass 接口Class对象
     */
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    private val retrofit by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    private val okHttpClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)     // 连接超时
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)           // 读取超时
            .addInterceptor(if (BuildConfig.DEBUG) BODY else NONE)  // 请求日志拦截器
            .retryOnConnectionFailure(true)   // 失败重连
            .build()
    }

    private val BODY by lazy(mode = LazyThreadSafetyMode.NONE) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val NONE by lazy(mode = LazyThreadSafetyMode.NONE) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }
}