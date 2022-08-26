package com.bachan.base.mvvm.v

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter

abstract class BaseFrameActivity<VB : ViewBinding, VM : ViewModel>(private val vmClass: Class<VM>) :
    AppCompatActivity() {

    protected val mViewModel: VM by lazy(mode = LazyThreadSafetyMode.NONE) {
        ViewModelProvider(this).get(vmClass)
    }

    protected val mBinding: VB by lazy(mode = LazyThreadSafetyMode.NONE) { initViewBinding() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        // ARouter 依赖注入
        ARouter.getInstance().inject(this)
        initView()
    }

    protected abstract fun initViewBinding(): VB
    protected abstract fun initView()
}