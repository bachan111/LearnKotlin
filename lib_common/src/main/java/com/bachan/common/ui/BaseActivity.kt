package com.bachan.common.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.bachan.base.v.BaseFrameActivity

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameActivity<VB, VM>(vmClass) {
}