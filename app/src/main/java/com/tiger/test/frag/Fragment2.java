package com.tiger.test.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.tiger.test.R;
import com.tiger.test.databinding.Fragment2Binding;
import com.tiger.test.frag.event.SwitchTabEvent;
import com.tiger.test.utils.LogUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by tiger on 2018/3/5.
 */

public class Fragment2 extends BaseFragment {

    private Fragment2Binding fragment2Binding = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");

        fragment2Binding = DataBindingUtil.inflate(inflater, R.layout.fragment2, container, false);
        fragment2Binding.setListener(this);

        return fragment2Binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void switchToFragment3(View view) {
        EventBus.getDefault().post(new SwitchTabEvent(TestFragmentActivity.TAB_FRAG_3));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
