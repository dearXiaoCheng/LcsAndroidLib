package com.lcs.quickDevelop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = object : BaseQuickAdapter<String, BaseViewHolder>(R.layout.activity_main) {
            override fun convert(holder: BaseViewHolder, item: String) {
            }
        }
        adapter.setOnItemClickListener { adapter, view, position -> }


    }
}