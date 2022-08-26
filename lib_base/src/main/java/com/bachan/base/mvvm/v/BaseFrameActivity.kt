package com.bachan.base.mvvm.v

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.quyunshuo.base.mvvm.v.FrameView
import com.quyunshuo.base.utils.EventBusRegister
import com.quyunshuo.base.utils.EventBusUtils
import java.lang.reflect.ParameterizedType

abstract class BaseFrameActivity<VB : ViewBinding, VM : ViewModel> :
    AppCompatActivity() , FrameView {


    protected val mViewModel: VM by lazy(mode = LazyThreadSafetyMode.NONE) {
        //init ViewModel | getActualTypeArguments [0]=是第一个泛型参数 | [1] = 是类的第二个泛型参数

        val vmClass: Class<VM> =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VM>
        ViewModelProvider(this).get(vmClass)
    }

    protected val mBinding: VB by lazy(mode = LazyThreadSafetyMode.NONE) {
        val vbClass: Class<VB> =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val inflate = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        inflate.invoke(null, layoutInflater) as VB
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        // ARouter 依赖注入
        ARouter.getInstance().inject(this)

        // 注册EventBus
        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) EventBusUtils.register(this)

        initView()
    }


    override fun onDestroy() {
        if (javaClass.isAnnotationPresent(EventBusRegister::class.java)) EventBusUtils.unRegister(
            this
        )
        super.onDestroy()
    }
}