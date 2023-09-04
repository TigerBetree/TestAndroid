package com.tiger.test.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.tiger.test.R;
import com.tiger.test.utils.LogUtil;

/**
 * Created by tiger on 2018/3/5.
 */

public class Fragment3 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        return inflater.inflate(R.layout.fragment3, container, false);
    }
}
