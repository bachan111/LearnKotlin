package com.bachan.main

import com.bachan.base.mvvm.m.BaseRepository

class MainRepository:BaseRepository() {
    suspend fun getString() = flowRequest<String> {
        emit("haha")
    }
}