package com.lcs.arch.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @ClassName: AppUtil
 * @Author: 刘春爽
 * @Date: 2021/3/17 11:30
 * @Description: 应用工具类
 */
object AppUtil {

    /**
     * 卸载app
     * @param context [Context]
     * @param packageName 包名
     */
    fun uninstallApp(context: Context, packageName: String) {
        val intent = Intent(Intent.ACTION_DELETE)
        intent.data = Uri.parse("package:$packageName")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }

    /**
     * 卸载app
     * @param packageName 包名
     * @return [Intent] 使用上下文启动即可
     */
    fun uninstallApp(packageName: String): Intent {
        val intent = Intent(Intent.ACTION_DELETE)
        intent.data = Uri.parse("package:$packageName")
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
}