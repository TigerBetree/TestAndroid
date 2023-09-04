package com.tiger.test.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.tiger.test.R;
import com.tiger.test.okhttp.TestOkHttpActivity;
import com.tiger.test.utils.LogUtil;


/**
 * Created by tiger on 2018/3/5.
 */

public class Fragment1 extends BaseFragment implements View.OnClickListener {

    private View layoutView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        layoutView = inflater.inflate(R.layout.fragment1, container, false);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        layoutView.findViewById(R.id.bt_okhttp).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_okhttp:
                TestOkHttpActivity.startActivity(getActivity());
                break;
        }
    }
}
