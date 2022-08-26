package com.bachan.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.bachan.base.utlis.SpUtils

open class BaseApp:Application() {
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    /**
     * 进行一些初始化的操作
     */
    protected open fun initialize() {
        // 腾讯 MMKV 初始化
        SpUtils.initMMKV(this)

        // 阿里路由 ARouter 初始化
        if (BuildConfig.DEBUG) {
            ARouter.openLog()     // 打印日志
            ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)
    }
}