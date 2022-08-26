package com.bachan.common.net

import com.bachan.common.net.api.ApiMainService

object NetRequest {
    // Home Service
    val mainService by lazy(mode = LazyThreadSafetyMode.NONE) {
        NetServiceCreator.create(ApiMainService::class.java)
    }

}