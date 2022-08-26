package com.bachan.main

import com.bachan.base.mvvm.m.BaseRepository
import com.bachan.common.net.NetRequest

class MainRepository:BaseRepository() {
    suspend fun getString() = flowRequest<String> {
        emit("haha")
    }

    suspend fun mockRequest() =
        flowRequest<String> {
            val testData = NetRequest.mainService.getTestData("mock")
            emit(testData.msgTest)
        }
}