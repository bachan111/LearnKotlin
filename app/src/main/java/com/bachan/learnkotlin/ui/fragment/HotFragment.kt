package com.bachan.learnkotlin.ui.fragment

import android.os.Bundle
import com.bachan.learnkotlin.base.BaseFragment

/**
 *
 *@author：practicing
 *@date:2022/4/12 0012 11:04
 *@description:
 */
class HotFragment : BaseFragment()  {
    private var mTitle: String? = null
    companion object {
        fun getInstance(title: String): HotFragment {
            val fragment = HotFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        TODO("Not yet implemented")
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun lazyLoad() {
        TODO("Not yet implemented")
    }
}