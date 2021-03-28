package com.lcs.arch.permission

import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

/**
 * @ClassName: PermissionExt
 * @Description: PermissionExt
 * @Author: 刘春爽
 * @Date: 2021/3/28 下午10:45
 */

fun FragmentActivity.requestPermission(vararg permissions: String) {

    val fragment = PermissionFragment()
    fragment.arguments = bundleOf("permissions" to permissions.toList().toTypedArray())

    fragment.granted = {
        supportFragmentManager.commit {
            remove(fragment)
        }
    }
    fragment.denied = {
        supportFragmentManager.commit {
            remove(fragment)
        }
    }
    this.supportFragmentManager.commit(true) {
        add(fragment, "")
    }
}