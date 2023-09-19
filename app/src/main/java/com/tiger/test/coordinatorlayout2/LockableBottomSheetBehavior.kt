package com.tiger.test.coordinatorlayout2

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlin.math.abs

class LockableBottomSheetBehavior<V : View?> : BottomSheetBehavior<V> {
    private var mAllowUserDragging = true

    /**
     * 按下点的X坐标
     */
    private var downX = 0

    /**
     * 按下点的Y坐标
     */
    private var downY = 0

    constructor()

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs
    )

    fun setAllowUserDragging(allowUserDragging: Boolean) {
        mAllowUserDragging = allowUserDragging
    }

    override fun onInterceptTouchEvent(
        parent: CoordinatorLayout,
        child: V,
        ev: MotionEvent
    ): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = ev.rawX.toInt()
                downY = ev.rawY.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                if ((downY - ev.rawY.toInt()) > 0) {
                    return false
                } else if (mAllowUserDragging && (downY - ev.rawY.toInt()) < 0 && abs(downY - ev.rawY.toInt()) > abs(downX - ev.rawX.toInt())){
                    return true
                }
            }
        }
        return if (!mAllowUserDragging) {
            false
        } else super.onInterceptTouchEvent(parent, child, ev)
    }

    interface ScrollListener {
        fun onBehaviorScroll(allowUserDragging: Boolean)
    }
}