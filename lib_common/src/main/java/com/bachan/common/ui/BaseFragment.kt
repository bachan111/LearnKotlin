package com.bachan.common.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.bachan.base.v.BaseFrameFragment

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(vmClass: Class<VM>) :
    BaseFrameFragment<VB, VM>(vmClass) {
}