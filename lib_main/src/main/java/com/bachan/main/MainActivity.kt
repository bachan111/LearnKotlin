package com.bachan.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bachan.common.ui.BaseActivity
import com.bachan.main.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class.java) {


    override fun initViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        mViewModel.msg.observe(this) {
            mBinding.mTv.text = it
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        mBinding.mTv.setOnClickListener {
            mViewModel.getString()
        }
    }
}