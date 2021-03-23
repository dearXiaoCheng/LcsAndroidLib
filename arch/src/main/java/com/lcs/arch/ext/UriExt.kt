package com.lcs.arch.ext

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.webkit.MimeTypeMap
import androidx.core.net.toFile
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import kotlin.random.Random

/**
 * @ClassName: UriExt
 * @Description: UriExt
 * @Author: 刘春爽
 * @Date: 2021/3/17 下午10:16
 */

fun Uri.parseFile(
    context: Context,
    targetDir: File = File(context.externalCacheDir!!.path)
): File? {

    //沙盒文件可以直接转为File使用，这里使用了ktx扩展
    if (this.isSandBox()) {
        return this.toFile()
    }

    //共享文件需要拷贝
    if (this.isShared()) {
        val contentResolver = context.contentResolver

        //获取文件名
        val displayName = run {
            val cursor = contentResolver.query(this, null, null, null, null)
            cursor?.let {
                if (it.moveToFirst())
                    it.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                else null
            }
        } ?: "${System.currentTimeMillis()}${Random.nextInt(0, 9999)}.${
            MimeTypeMap.getSingleton()
                .getExtensionFromMimeType(contentResolver.getType(this))
        }"

        //获得输入流
        val inputStream: InputStream? = contentResolver.openInputStream(this)
        return if (inputStream != null) {
            File("${targetDir.path}/$displayName")
                .apply {
                    val fos = FileOutputStream(this)
                    android.os.FileUtils.copy(inputStream, fos)
                    fos.close()
                    inputStream.close()
                }
        } else null


    }

    return null
}


/**
 * 判断Uri是不是在download目录下
 */
fun Uri.isDownloadsProvider(): Boolean {
    return "com.android.providers.downloads.documents" == this.authority
}

/**
 * 判断Uri是不是沙盒文件
 *
 * 沙盒文件Uri的scheme是file://
 * @see ContentResolver.SCHEME_FILE
 */
fun Uri.isSandBox(): Boolean {
    return ContentResolver.SCHEME_FILE == this.scheme
}

/**
 * 判断Uri是不是共享文件
 *
 * 沙盒文件Uri的scheme是content://
 * @see ContentResolver.SCHEME_CONTENT
 */
fun Uri.isShared(): Boolean {
    return ContentResolver.SCHEME_CONTENT == this.scheme
}