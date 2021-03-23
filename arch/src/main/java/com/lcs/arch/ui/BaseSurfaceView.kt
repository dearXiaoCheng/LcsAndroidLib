package com.lcs.arch.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 * @ClassName: BaseSurfaceView
 * @Description: BaseSurfaceView
 * @Author: 刘春爽
 * @Date: 2021/3/23 13:56
 */
abstract class BaseSurfaceView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : SurfaceView(context, attrs), SurfaceHolder.Callback, Runnable {

    private var mHolder: SurfaceHolder = holder

    private var mCanvas: Canvas? = null

    private var isDrawing = false

    init {
        mHolder.addCallback(this)
        isFocusable = true
        isFocusableInTouchMode = true
    }

    final override fun surfaceCreated(holder: SurfaceHolder) {
        isDrawing = true
        Thread(this).start()
    }

    final override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
    }

    final override fun surfaceDestroyed(holder: SurfaceHolder) {
        isDrawing = false
        holder.removeCallback(this)
    }

    override fun run() {
        while (isDrawing) {
            try {
                mCanvas = mHolder.lockCanvas()
                doDraw(mCanvas)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                mCanvas?.let {
                    mHolder.unlockCanvasAndPost(it)
                }
            }
        }
    }

    abstract fun doDraw(canvas: Canvas?)
}