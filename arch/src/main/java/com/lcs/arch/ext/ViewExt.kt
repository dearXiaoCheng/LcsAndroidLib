package com.lcs.arch.ext

import android.view.View
import android.widget.EditText

/**
 * @ClassName: ViewExt
 * @Description: ViewExt
 * @Author: 刘春爽
 * @Date: 2021/3/16 下午10:00
 */

/**
 * 显示View：设置为[View.VISIBLE]
 */
fun View.show() {
    this.visibility = View.VISIBLE
}

/**
 * 使View消失：设置为[View.GONE]
 */
fun View.gone() {
    this.visibility = View.GONE
}

/**
 * 隐藏View：设置为[View.INVISIBLE]
 */
fun View.hide() {
    this.visibility = View.INVISIBLE
}

/**
 * 返回[EditText]的[EditText.getText]，并转为String
 */
fun EditText.textString(): String {
    return this.text.toString()
}