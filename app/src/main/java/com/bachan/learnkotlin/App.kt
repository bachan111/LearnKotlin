package com.bachan.learnkotlin

import androidx.multidex.MultiDex
import com.bachan.base.BaseApp
import com.bachan.common.CommonApp


class App : CommonApp() {

    override fun onCreate() {
        MultiDex.install(this)
        super.onCreate()
    }

}