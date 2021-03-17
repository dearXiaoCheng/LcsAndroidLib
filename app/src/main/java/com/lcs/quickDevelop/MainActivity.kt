package com.lcs.quickDevelop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lcs.arch.adapter.BaseAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main) {
            override fun convert(holder: BaseViewHolder, item: String) {
            }
        }
        adapter.setOnItemClickListener { adapter, view, position -> }

        val adapter2 = object : BaseAdapter<String, ViewDataBinding>() {
            override val layoutId: Int
                get() = R.layout.activity_main

            override fun onBindData(binding: ViewDataBinding, item: String) {

            }
        }

    }
}