package com.lcs.arch.adapter

import android.view.View

/**
 * @ClassName: OnItemClick
 * @Description: OnItemClick
 * @Author: 刘春爽
 * @Date: 2021/3/12 下午9:57
 */
interface OnItemClickListener {
    fun <T> onItemClick(adapter: BaseAdapter<*, *>, view: View, position: Int)
}