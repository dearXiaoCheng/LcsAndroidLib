package com.lcs.arch.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat

/**
 * @ClassName: NetUtils
 * @Author: 刘春爽
 * @Date: 3/9/21 10:03 AM
 * @Description: NetUtils
 */
object NetUtils {

    /**
     * 网络是否可用
     * @return true 网络可用，false 网络不可用
     */
    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            ContextCompat.getSystemService(context, ConnectivityManager::class.java) ?: return false
        val allNetwork: Array<Network> = connectivityManager.allNetworks
        allNetwork.forEach {
            val networkCapabilities = connectivityManager.getNetworkCapabilities(it)
            networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                ?.let { status ->
                    if (status) {
                        return true
                    }
                }
        }
        return false
    }


//    fun isWiFiConnected(context: Context): Boolean {
//        val connectivityManager =
//            ContextCompat.getSystemService(context, ConnectivityManager::class.java) ?: return false
//        val allNetwork : Array<Network> = connectivityManager.allNetworks
//
//        Log.e("cs","所有网络: ${allNetwork.size} ${allNetwork.toString()}")
//        allNetwork.forEach {
//            val networkCapabilities = connectivityManager.getNetworkCapabilities(it)
//            networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI).also {
//                return it
//            }
//        }
//        return false
//    }
}