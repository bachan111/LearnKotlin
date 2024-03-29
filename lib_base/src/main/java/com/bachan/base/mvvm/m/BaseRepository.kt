package com.bachan.base.mvvm.m

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

open class BaseRepository {
    protected suspend fun <T> flowRequest(requestBlock: suspend FlowCollector<T>.() -> Unit) =
        flow (
            block = requestBlock
        ).flowOn(Dispatchers.IO)     // 通过 flowOn 切换到 io 线程
}