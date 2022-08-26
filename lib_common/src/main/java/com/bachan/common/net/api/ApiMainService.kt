package com.bachan.common.net.api

import com.bachan.common.entities.TestBean
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMainService {
    // Retrofit 2.6版本开始支持协程 只需要将抽象方法写成挂起函数即可
    @GET()
    suspend fun getTestData(@Query("test") test: String): TestBean
}