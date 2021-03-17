package com.lcs.arch

import android.app.Application
import android.content.Context

/**
 * @ClassName: BaseApp
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:32
 * @Description: BaseApp
 */
abstract class BaseApp : Application() {

    companion object {
        var mAppContext: Context? = null
            get() {
                if (field == null) {
                    throw NullPointerException("请继承BaseApp")
                }
                return field!!
            }
            private set
    }

    override fun onCreate() {
        super.onCreate()
        mAppContext = this
        initApp()
    }

    /**
     * 初始化app
     */
    abstract fun initApp()
}