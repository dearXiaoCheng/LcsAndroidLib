package com.lcs.arch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * @ClassName: BaseFragment
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:11
 * @Description: BaseFragment
 */
abstract class BaseFragment<DB : ViewDataBinding>(val layoutId: Int) : Fragment() {

    lateinit var ui: DB
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ui = DataBindingUtil.inflate(layoutInflater, layoutId, container, false)
        return ui.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    abstract fun initView()


}