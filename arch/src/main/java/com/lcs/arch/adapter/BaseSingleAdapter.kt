package com.lcs.launcher

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName: BaseSingleAdapter
 * @Author: 刘春爽
 * @Date: 21-3-6 下午11:13
 * @Description: BaseSingleAdapter
 */
abstract class BaseSingleAdapter<T, UI : ViewDataBinding> :
    RecyclerView.Adapter<BaseSingleAdapter.ViewHolder>() {

    lateinit var context: Context
        private set

    var data: T? = null
        set(value) {
            field = value
            notifyItemChanged(0)
        }

    /**
     * 布局文件的id，在子类中实现（可以在构造函数中重写）
     */
    abstract val layoutId: Int

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: UI = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        val viewHolder = ViewHolder(binding)
        onItemViewHolderCreated(viewHolder, viewType)
        return viewHolder
    }

    protected open fun onItemViewHolderCreated(viewHolder: ViewHolder, viewType: Int) {}

    open class ViewHolder(open val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        onBindData(holder.binding as UI, data, position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        //只有一条数据
        return 1
    }

    /**
     * 显示数据时使用。通过[binding]设置布局中对应的变量[item]更新数据。
     */
    abstract fun onBindData(binding: UI, item: T?, position: Int)


}