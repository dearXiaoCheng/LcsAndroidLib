package com.lcs.arch.ext

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

/**
 * @ClassName: SoftKeyboardExt
 * @Description: SoftKeyboardExt
 * @Author: 刘春爽
 * @Date: 2021/3/28 下午5:30
 */


fun View.hideSoftKeyboard() {
    ContextCompat.getSystemService(context, InputMethodManager::class.java)
        ?.hideSoftInputFromWindow(windowToken, 0)
}