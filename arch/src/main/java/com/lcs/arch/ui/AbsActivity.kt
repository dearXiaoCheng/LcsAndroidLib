package com.lcs.arch.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @ClassName: BaseActivity
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:05
 * @Description: BaseActivity
 */
abstract class AbsActivity<UI : ViewDataBinding>(@LayoutRes val layoutId: Int) :
    AppCompatActivity() {


    private lateinit var ui: UI

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeCreate()
        super.onCreate(savedInstanceState)
        ui = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    open fun beforeCreate() {

    }


}