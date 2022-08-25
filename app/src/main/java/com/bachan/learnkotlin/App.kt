package com.bachan.learnkotlin

import androidx.multidex.MultiDex
import com.bachan.base.BaseApp


class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

}