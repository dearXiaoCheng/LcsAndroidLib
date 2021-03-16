package com.lcs.arch.ext

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * @ClassName: ResourcesExt
 * @Author: 刘春爽
 * @Date: 21-3-6 下午10:34
 * @Description: ResourcesExt
 */

/**
 * 获取颜色
 * @param color 颜色资源[ColorRes]
 * @return [ColorInt]
 */
@ColorInt
fun Context.colorOf(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}


/**
 * 获取Drawable
 * @param drawable 图片资源[ColorRes]
 * @return 图片Drawable，可能为空
 */
fun Context.drawableOf(@DrawableRes drawable: Int): Drawable? {
    return ContextCompat.getDrawable(this, drawable)
}