package com.bachan.learnkotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import kotlin.properties.Delegates

/**
 *
 *@author：practicing
 *@date:2022/4/12 0012 09:43
 *@description:
 */
class App:Application() {

    companion object{
        private val TAG = "MyApplication"
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }
    private val mActivityLifecycleCallbacks = object : ActivityLifecycleCallbacks{
        override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        }

        override fun onActivityStarted(p0: Activity) {
        }

        override fun onActivityResumed(p0: Activity) {
        }

        override fun onActivityPaused(p0: Activity) {
        }

        override fun onActivityStopped(p0: Activity) {
        }

        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG,"onDestroy: " + activity.componentName.className)
        }


    }
}