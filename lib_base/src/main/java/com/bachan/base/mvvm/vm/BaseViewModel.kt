package com.bachan.base.mvvm.vm

import androidx.lifecycle.ViewModel
import com.bachan.base.mvvm.m.BaseRepository

abstract class BaseViewModel<R : BaseRepository> : ViewModel() {
    protected val mRepository: R by lazy { initRepository() }
    protected abstract fun initRepository(): R
}