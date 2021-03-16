package com.lcs.arch.adapter

/**
 * @ClassName: OnItemClick
 * @Description: OnItemClick
 * @Author: 刘春爽
 * @Date: 2021/3/12 下午9:57
 */
interface OnItemClick<T> {
    fun onItemClick(data: T, position: Int)
}