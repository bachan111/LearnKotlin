package com.bachan.main
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.bachan.base.ktx.toast
import com.bachan.base.utlis.sendEvent
import com.bachan.common.constant.RouteUrl
import com.bachan.common.entities.TestBean
import com.bachan.common.ui.BaseActivity
import com.bachan.main.databinding.ActivityMainBinding
import com.quyunshuo.base.utils.EventBusRegister
import org.greenrobot.eventbus.Subscribe

@EventBusRegister
@Route(path = RouteUrl.MainActivity)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Override
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

        sendEvent(TestBean("EventBus"))
    }

    @Subscribe
    fun onEvent(event: TestBean) {
        toast(event.msgTest)
    }
}