package com.tiger.test.gallery2;

import android.view.View;

/**
 * 滑动过程中的缩放
 */
public class Transformer2 implements GalleryLayoutManager2.ItemTransformer {
    @Override
    public void transformItem(GalleryLayoutManager2 layoutManager, View item, float fraction) {
        item.setPivotX(item.getWidth() / 2.F);
        item.setPivotY(item.getHeight() / 2.F);
        float scale = 1 - 0.3F * Math.abs(fraction);
        item.setScaleX(scale);
        item.setScaleY(scale);
    }
}