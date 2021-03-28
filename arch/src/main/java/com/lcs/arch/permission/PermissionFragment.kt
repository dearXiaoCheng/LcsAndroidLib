package com.lcs.arch.permission

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @ClassName: PermissionFragment
 * @Description: PermissionFragment
 * @Author: 刘春爽
 * @Date: 2021/3/28 下午10:40
 */
class PermissionFragment : Fragment() {

    private var permissions: Array<String>? = emptyArray<String>()


    var granted: (() -> Unit?)? = null
    var denied: ((deniedPermissions: List<String>) -> Unit?)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            permissions = it.getStringArray("permissions")
            requestPermissions(permissions!!, 99999)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != 99999) {
            return
        }

        val deny = mutableListOf<String>()
        grantResults.filter {
            it != PackageManager.PERMISSION_GRANTED
        }.forEachIndexed { index, _ ->
            deny.add(permissions[index])
        }
        if (deny.isEmpty()) {
            //全部授权
            granted?.invoke()
        } else {
            //未授权所有权限
            denied?.invoke(deny)
        }
    }
}