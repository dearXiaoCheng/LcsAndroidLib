package com.lcs.arch.ui

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ktx.immersionBar
import com.lcs.arch.R
import com.lcs.arch.databinding.ActivityBaseBinding

/**
 * @ClassName: BaseActivity
 * @Author: 刘春爽
 * @Date: 21-3-6 下午11:17
 * @Description: BaseActivity
 */
abstract class BaseActivity<DB : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    AppCompatActivity() {

    val TAG: String = javaClass.simpleName

    lateinit var ui: DB
        private set

    private lateinit var baseUi: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(TAG, "onCreate: ${savedInstanceState}")

        baseUi = DataBindingUtil.setContentView(this, R.layout.activity_base)
        initImmersionBar()

        ui = DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
        baseUi.content.addView(ui.root)
        ui.lifecycleOwner = this
        restore(savedInstanceState)
        ui.root.post {
            initView()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected open fun initImmersionBar() {
        immersionBar {
            statusBarView(baseUi.statusBarView)
            autoDarkModeEnable(true)
        }
    }

    open fun restore(savedInstanceState: Bundle?) {

    }

    abstract fun initView()
}