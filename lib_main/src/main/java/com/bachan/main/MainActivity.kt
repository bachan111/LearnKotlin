package com.bachan.main
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bachan.common.constant.RouteKey
import com.bachan.common.constant.RouteUrl
import com.bachan.common.ui.BaseActivity
import com.bachan.main.databinding.ActivityMainBinding

@Route(path = RouteUrl.MainActivity)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java) {


    override fun initViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        mViewModel.msg.observe(this) {
            mBinding.mTv.text = it
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        mBinding.mTv.setOnClickListener {
            mViewModel.getTestString()
        }
        mBinding.mIntentBtn.setOnClickListener{
//            ARouter.getInstance().build(RouteUrl.MainActivity2)
//                .withString(RouteKey.KEY_NAME,"ARouter").navigation()

            mViewModel.getTestString()
        }
    }
}