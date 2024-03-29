package com.bachan.main
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.bachan.base.ktx.toast
import com.bachan.common.constant.RouteKey
import com.bachan.common.constant.RouteUrl
import com.bachan.common.ui.BaseActivity
import com.bachan.main.databinding.ActivityMainBinding

@Route(path = RouteUrl.MainActivity)
class MainActivity2 : BaseActivity<ActivityMainBinding, MainViewModel>() {
    @Autowired(name = RouteKey.KEY_NAME)
    lateinit var name: String

    @Override
    override fun initView() {
        toast(name)
    }
}