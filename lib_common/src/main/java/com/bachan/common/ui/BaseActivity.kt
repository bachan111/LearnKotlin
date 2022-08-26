package com.bachan.common.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.bachan.base.mvvm.v.BaseFrameActivity

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel> :
    BaseFrameActivity<VB, VM>() {
}