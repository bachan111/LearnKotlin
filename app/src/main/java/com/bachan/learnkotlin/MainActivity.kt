package com.bachan.learnkotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import androidx.fragment.app.FragmentTransaction
import com.bachan.learnkotlin.base.BaseActivity
import com.bachan.learnkotlin.mvp.model.bean.TabEntity
import com.bachan.learnkotlin.ui.fragment.DiscoveryFragment
import com.bachan.learnkotlin.ui.fragment.HomeFragment
import com.bachan.learnkotlin.ui.fragment.HotFragment
import com.bachan.learnkotlin.ui.fragment.MineFragment
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseActivity() {

    private val mTitles = arrayOf("每日精选", "发现", "热门", "我的")

    // 未被选中的图标
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    // 被选中的图标
    private val mIconSelectIds = intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)

    private val mTabEntities = ArrayList<CustomTabEntity>()

    private var mHomeFragment: HomeFragment? = null
    private var mDiscoveryFragment: DiscoveryFragment? = null
    private var mHotFragment: HotFragment? = null
    private var mMineFragment: MineFragment? = null

    //默认为0
    private var mIndex = 0


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState, persistentState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        if (tab_layout != null){
            outState.putInt("currTabIndex", mIndex)
        }
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun initData() {
    }

    override fun initView() {
    }

    override fun start() {
    }

    private fun switchFragment(position: Int) {
        val transaction =  supportFragmentManager.beginTransaction()
        hideFragment(transaction)
        when(position){
            0//首页
            ->mHomeFragment?.let {
                transaction.show(it)
            }?:HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container,it,"home")
            }
            1  //发现
            ->mHomeFragment?.let {
                transaction.show(it)
            }?:HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container,it,"home")
            }
            2  //热门
            ->mHomeFragment?.let {
                transaction.show(it)
            }?:HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container,it,"home")
            }
            3 //我的
            ->mHomeFragment?.let {
                transaction.show(it)
            }?:HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container,it,"home")
            }

            else -> {

            }
        }
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it) }
        mHotFragment?.let { transaction.hide(it) }
        mMineFragment?.let { transaction.hide(it) }
    }

    private fun initTab() {
        (0 until mTitles.size).mapTo(mTabEntities){
            TabEntity(mTitles[it],mIconSelectIds[it],mIconUnSelectIds[it])
        }
        tab_layout.setTabData(mTabEntities)
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {
                TODO("Not yet implemented")
            }
        })
    }

    private var mExitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("再按一次退出程序")
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}