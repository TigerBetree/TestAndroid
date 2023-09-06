package com.tiger.test.coordinatorlayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.tiger.test.R;
import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.LogUtil;


/**
 * Created by tiger on 2018/3/5.
 */

public class TestCLReadFragment extends BaseFragment implements View.OnClickListener {

    private View layoutView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        layoutView = inflater.inflate(R.layout.fragment_read, container, false);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
    }

    @Override
    public void onClick(View v) {
    }
}
