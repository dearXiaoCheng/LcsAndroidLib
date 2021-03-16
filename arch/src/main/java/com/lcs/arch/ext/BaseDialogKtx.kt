package com.lcs.arch.ext

import androidx.fragment.app.FragmentManager
import com.lcs.arch.ui.BaseSimpleDialog

/**
 * @ClassName: BaseDialogKtx
 * @Description: BaseDialogKtx
 * @Author: 刘春爽
 * @Date: 2021/3/11 下午11:16
 */

fun BaseSimpleDialog<*>.showDialog(
    manager: FragmentManager,
    tag: String? = null,
    block: BaseSimpleDialog<*>.() -> Unit
) {
    this.showNow(manager, tag)
    block()
}