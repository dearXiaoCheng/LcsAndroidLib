package com.lcs.arch.utils

import java.io.File

/**
 * @ClassName: DeviceUtils
 * @Description: DeviceUtils
 * @Author: 刘春爽
 * @Date: 2021/3/31 14:16
 */
object DeviceUtils {
    fun isRoot(): Boolean {
        val su = "su"
        val locations = arrayOf(
            "/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/",
            "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/",
            "/system/sbin/", "/usr/bin/", "/vendor/bin/"
        )
        locations.forEach {
            if (File(it + su).exists()) {
                return true
            }
        }
        return false
    }
}