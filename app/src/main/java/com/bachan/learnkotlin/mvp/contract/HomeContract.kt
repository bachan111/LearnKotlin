package com.bachan.learnkotlin.mvp.contract

import com.bachan.learnkotlin.base.IBaseView
import com.bachan.learnkotlin.mvp.model.bean.HomeBean

/**
 *
 *@author：practicing
 *@date:2022/4/13 0013 09:50
 *@description:
 */
interface HomeContract {

    interface View : IBaseView {
        /**
         * 设置第一次请求的数据
         */
        fun setHomeData(homeBean: HomeBean)

        /**
         * 设置加载更多的数据
         */
        fun setMoreData(itemList: ArrayList<HomeBean.Issue.Item>)

        /**
         * 显示错误信息
         */
        fun showError(msg: String, errorCode: Int)
    }

    interface Presenter {

        /**
         * 获取首页精选数据
         */
        fun requestHomeData(num: Int)

        /**
         * 加载更多数据
         */
        fun loadMoreData()


    }
}