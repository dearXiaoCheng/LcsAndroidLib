package com.lcs.arch.ext

import android.widget.EditText

/**
 * @ClassName: ViewExt
 * @Description: ViewExt
 * @Author: 刘春爽
 * @Date: 2021/3/16 下午10:00
 */


/**
 * 返回[EditText]的[EditText.getText]，并转为String
 */
fun EditText.textString(): String {
    return this.text.toString()
}