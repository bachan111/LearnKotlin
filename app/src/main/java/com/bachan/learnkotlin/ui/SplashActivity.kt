package com.bachan.learnkotlin.ui

import android.Manifest
import android.content.Intent
import android.graphics.Typeface
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.bachan.learnkotlin.App
import com.bachan.learnkotlin.MainActivity
import com.bachan.learnkotlin.R
import com.bachan.learnkotlin.base.BaseActivity
import com.bachan.learnkotlin.utils.AppUtils
import kotlinx.android.synthetic.main.activity_splash.*
import pub.devrel.easypermissions.EasyPermissions

class SplashActivity : BaseActivity() {

    private var textTypeface: Typeface?=null

    private var descTypeFace: Typeface?=null

    private var alphaAnimation: AlphaAnimation?=null

    init {
        textTypeface = Typeface.createFromAsset(App.context.assets, "fonts/Lobster-1.4.otf")
        descTypeFace = Typeface.createFromAsset(App.context.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")
    }

    override fun layoutId(): Int = R.layout.activity_splash

    override fun initData() {
        TODO("Not yet implemented")
    }

    override fun initView() {
        tv_app_name.typeface = textTypeface
        tv_splash_desc.typeface = descTypeFace
        tv_version_name.text = "v${AppUtils.getVerName(App.context)}"

        alphaAnimation = AlphaAnimation(0.3f,1.0f)
        alphaAnimation?.duration = 2000
        alphaAnimation?.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                goto()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })
        checkPermission()
    }

    private fun checkPermission() {
        val perms = arrayOf(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        EasyPermissions.requestPermissions(this,"KotlinMvp应用需要以下权限，请允许", 0, *perms)
    }

    private fun goto() {
    }

    override fun start() {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        if (requestCode == 0){
            if (perms.isNotEmpty()) {
                if (perms.contains(Manifest.permission.READ_PHONE_STATE)
                    && perms.contains(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (alphaAnimation != null) {
                        iv_web_icon.startAnimation(alphaAnimation)
                    }
                }
            }
        }
    }
}