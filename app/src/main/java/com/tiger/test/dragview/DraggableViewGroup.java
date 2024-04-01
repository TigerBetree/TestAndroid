package com.tiger.test.dragview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class DraggableViewGroup extends ViewGroup {

    private View mDraggableView;
    private float mLastX;
    private float mLastY;

    public DraggableViewGroup(Context context) {
        super(context);
    }

    public DraggableViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DraggableViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (mDraggableView != null) {
            mDraggableView.layout(l, t, r, b);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = event.getX() - mLastX;
                float deltaY = event.getY() - mLastY;
                mLastX = event.getX();
                mLastY = event.getY();
                handleDrag(deltaX, deltaY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    private void handleDrag(float deltaX, float deltaY) {
        if (mDraggableView != null) {
            mDraggableView.setTranslationX(mDraggableView.getTranslationX() + deltaX);
            mDraggableView.setTranslationY(mDraggableView.getTranslationY() + deltaY);
        }
    }

    public void setDraggableView(View view) {
        mDraggableView = view;
    }
}