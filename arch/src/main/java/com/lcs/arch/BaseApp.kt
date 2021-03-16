package com.lcs.arch

import android.app.Application

/**
 * @ClassName: BaseApp
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:32
 * @Description: BaseApp
 */
abstract class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initApp()
    }

    /**
     * 初始化app
     */
    abstract fun initApp()
}