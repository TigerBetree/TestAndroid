package com.tiger.test.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

@SuppressLint("AppCompatCustomView")
public class CenterDrawableTextView extends android.widget.TextView {

    private Drawable mDrawableLeft;
    
    public CenterDrawableTextView(Context context) {
        super(context);
    }

    public CenterDrawableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterDrawableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (getDrawableLeft() != null) {
            mDrawableLeft = getDrawableLeft();
            // 获取drawable的宽度
            int drawableWidth = mDrawableLeft.getIntrinsicWidth();
            // 调整drawable的边界以使其左边缘与文本基线对齐
            mDrawableLeft.setBounds(0, 0, drawableWidth, mDrawableLeft.getIntrinsicHeight());
            // 更新文本内边距以包含drawable的空间
            setPadding(drawableWidth, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    private Drawable getDrawableLeft() {
        Drawable[] drawables = getCompoundDrawables();
        return drawables[0];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 计算drawable和文本的整体居中位置
        float totalWidth = getWidth();
        float textWidth = getPaint().measureText(getText().toString());
        float compoundDrawableWidth = getTotalCompoundDrawablesWidth();

        float centerOffset = (totalWidth - textWidth - compoundDrawableWidth) / 2f;
        
        // 先绘制drawable
        if (mDrawableLeft != null) {
            canvas.save();
            canvas.translate(centerOffset - mDrawableLeft.getBounds().width(), 0);
            mDrawableLeft.draw(canvas);
            canvas.restore();
        }

        // 绘制文本，保持居中
        canvas.drawText(getText().toString(), centerOffset + mDrawableLeft.getBounds().width(), getTextCenterY(), getPaint());
    }

    private float getTextCenterY() {
        Paint paint = getPaint();
        Rect bounds = new Rect();
        String text = getText().toString();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return getHeight() / 2f - bounds.exactCenterY();
    }

    private int getTotalCompoundDrawablesWidth() {
        int totalWidth = 0;
        if (getDrawableLeft() != null) {
            totalWidth += getDrawableLeft().getIntrinsicWidth();
        }
        // 如果有其他方向的drawable，也需计算其宽度
        // ...
        return totalWidth;
    }
}