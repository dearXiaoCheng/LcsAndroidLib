//package com.lcs.arch.adapter
//
//import android.view.View
//import android.view.ViewGroup
//import androidx.databinding.ViewDataBinding
//import androidx.recyclerview.widget.RecyclerView
//
///**
// * @ClassName: BaseMultiTypeAdapter
// * @Description: BaseMultiTypeAdapter
// * @Author: 刘春爽
// * @Date: 2021/3/13 13:06
// */
//class BaseMultiTypeAdapter<T>(override val layoutId: Int) :
//    BaseAdapter<T, ViewDataBinding>() {
//
//
//    override fun getItemViewType(position: Int): Int {
//        //如果data实现了MultiType接口，则按提供的type返回，否则使用layoutId
//        return (data[position] as? MultiType)?.type() ?: layoutId
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        when (viewType) {
//
//        }
//    }
//
//    override fun onBindData(binding: ViewDataBinding, item: T) {
//
//    }
//
//}
//
// class MultiTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
// }
