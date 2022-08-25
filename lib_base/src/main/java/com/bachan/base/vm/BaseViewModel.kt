package com.bachan.base.vm

import androidx.lifecycle.ViewModel
import com.bachan.base.m.BaseRepository

abstract class BaseViewModel<R : BaseRepository> : ViewModel() {
    protected val mRepository: R by lazy { initRepository() }
    protected abstract fun initRepository(): R
}