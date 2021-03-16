package com.lcs.arch.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

/**
 * @ClassName: BaseDialog
 * @Description: BaseDialog
 * @Author: 刘春爽
 * @Date: 2021/3/11 下午10:02
 */
open class BaseSimpleDialog<VB : ViewDataBinding>(val layoutId: Int) : DialogFragment() {


    lateinit var dlg: VB
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.getWindow()?.getDecorView()?.setBackgroundColor(Color.TRANSPARENT);
        dlg = DataBindingUtil.inflate(inflater, layoutId, container, false)
        dialog?.window?.let {
            it.decorView.setPadding(0, 0, 0, 0)
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.setDimAmount(0.4f)
            val lp = it.attributes
            lp.apply {
                gravity = Gravity.TOP
                width = WindowManager.LayoutParams.MATCH_PARENT
                height = WindowManager.LayoutParams.WRAP_CONTENT
                horizontalMargin = 0f
                x = 0
                y = 0
            }
            it.attributes = lp

        }

        return dlg.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun attachToView(view: View) {
        dialog?.window?.let {
            val lp = it.attributes
            lp.apply {
                gravity = Gravity.TOP
                y = view.height
            }
            it.attributes = lp
        }
    }

    open fun setLayout() {

    }
}