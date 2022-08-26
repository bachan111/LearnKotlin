package com.bachan.common.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.bachan.base.mvvm.v.BaseFrameFragment

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> :
    BaseFrameFragment<VB, VM>() {
}