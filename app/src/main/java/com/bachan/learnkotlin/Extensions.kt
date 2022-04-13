package com.bachan.learnkotlin

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 *
 *@author：practicing
 *@date:2022/4/13 0013 09:45
 *@description:
 */

fun Context.showToast(content:String):Toast{
    val toast = Toast.makeText(App.context,content,Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Fragment.showToast(content: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, content, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun durationFormat(duration: Long?): String {
    val minute = duration!! / 60
    val second = duration % 60
    return if (minute <= 9) {
        if (second <= 9) {
            "0$minute' 0$second''"
        } else {
            "0$minute' $second''"
        }
    } else {
        if (second <= 9) {
            "$minute' 0$second''"
        } else {
            "$minute' $second''"
        }
    }
}