package com.lcs.arch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName: BaseAdapter
 * @Author: 刘春爽
 * @Date: 21-3-6 下午11:13
 * @Description: BaseAdapter
 */
abstract class BaseAdapter<T, UI : ViewDataBinding> :
    RecyclerView.Adapter<BaseAdapter.ViewHolder>() {

    /**
     * 数据列表，只支持一种类型的数据
     */
    protected val data = mutableListOf<T>()

    /**
     * 布局文件的id，在子类中实现（可以在构造函数中重写）
     */
    abstract val layoutId: Int

    private var onItemClick: OnItemClick<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: UI = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    open class ViewHolder(open val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindData(holder.binding as UI, data[position])
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = data.size

    /**
     * 显示数据时使用。通过[binding]设置布局中对应的变量[item]更新数据。
     */
    abstract fun onBindData(binding: UI, item: T)

    fun setData(dataList: List<T>) {
        data.clear()
        data.addAll(dataList)
        notifyDataSetChanged()
    }

}