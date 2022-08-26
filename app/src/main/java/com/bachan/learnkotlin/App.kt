package com.bachan.learnkotlin

import androidx.multidex.MultiDex
import com.bachan.base.BaseApp
import com.bachan.common.CommonApp
import org.greenrobot.eventbus.EventBus


class App : CommonApp() {
    override fun initialize() {
        MultiDex.install(this)
        // 开启EventBusAPT,优化反射效率
        EventBus
            .builder()
//            .addIndex(MainEventIndex())
            .installDefaultEventBus()
        super.initialize()
    }

}