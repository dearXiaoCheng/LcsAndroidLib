package com.lcs.arch.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView


/**
 * @ClassName: BaseViewHolder
 * @Author: 刘春爽
 * @Date: 21-3-6 下午11:14
 * @Description: BaseViewHolder
 */
abstract class BaseViewHolder<T, UI : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(
    itemView
) {


    private var binding: UI? = DataBindingUtil.getBinding(this.itemView)

    abstract fun onBindData(data: T, position: Int)


    fun onBaseBindViewHolder(data: T, position: Int) {
        onBindData(data, position)
        binding!!.executePendingBindings()
    }

}